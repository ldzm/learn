package com.github.ldzm.nio;

import com.github.ldzm.commom.CharsetHelper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 代码来自：http://blog.csdn.net/suifeng3051/article/details/48441629
 * 感谢博主的无私奉献
 *
 * 提问：NIO是非阻塞的, 但在listen里调用的selector.select(); 方法会阻塞。这和NIO非阻塞岂不是矛盾了？
 * 回答：非阻塞指的是 IO 事件本身不阻塞,但是获取 IO 事件的 select 方法是需要阻塞等待的.
 * 区别是阻塞的 IO 会阻塞在 IO 操作上, NIO 阻塞在事件获取上,没有事件就没有 IO,
 * 从高层次看 IO 就不阻塞了.也就是说只有 IO 已经发生那么我们才评估 IO 是否阻塞,
 * 但是 select 阻塞的时候 IO 还没有发生,何谈 IO 的阻塞呢. NIO 的本质是延迟
 * IO 操作到真正发生 IO 的时候,而不是以前的只要 IO 流打开了就一直等待 IO 操作.
 *
 * 可能是因为selector可以注册多个通道，它的listen()是监听所有通道的动作，所以其实它看起来还是非阻塞的。
 *
 * 提问：如果正在处理事件时，有新的连接要接入，那么新的连接还是要等待吗？ 要是某个事件处理的时间非常长，那新连接是不是要一直等待？ 不太理解。
 * 回答1：要是某个事件处理的时间非常长，新连接是要一直等待的，所以nio的多路复用适合大量短连接的处理场景
 * 回答2：搞懂了，对于某个事件如果处理时间特别长那么可以把这个时间重新扔到一个开辟的线程池里面执行，也就是在再一次做异步处理。
 */
public class MultiPortEcho {
    private int ports[];
    private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

    public MultiPortEcho(int ports[]) throws IOException {
        this.ports = ports;
        listen();
    }

    private void listen() throws IOException {
        Selector selector = getSelector();

        //4. 从Selector中获取感兴趣的事件，即开始监听，进入内部循环：
        while (true) {
            //这个方法会阻塞，直到至少有一个已注册的事件发生。当一个或者更多的事件发生时
            // select() 方法将返回所发生的事件的数量。
            int num = selector.select();

            //返回发生了事件的 SelectionKey 对象的一个集合
            Set selectedKeys = selector.selectedKeys();

            //我们通过迭代 SelectionKeys 并依次处理每个 SelectionKey 来处理事件
            //对于每一个 SelectionKey，您必须确定发生的是什么 I/O 事件，以及这个事件影响哪些 I/O 对象。
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                it.remove();
                process(selector, key);
            }
            // System.out.println( "going to clear" );
            // selectedKeys.clear();
            // System.out.println( "cleared" );
        }
    }

    private void process(Selector selector, SelectionKey key) throws IOException {
        //5. 监听新连接。程序执行到这里，我们仅注册了 ServerSocketChannel
        //并且仅注册它们“接收”事件。为确认这一点
        //我们对 SelectionKey 调用 readyOps() 方法，并检查发生了什么类型的事件
        if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
            //6. 接收了一个新连接。因为我们知道这个服务器套接字上有一个传入连接在等待
            //所以可以安全地接受它；也就是说，不用担心 accept() 操作会阻塞
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            // 7. 将新连接注册到selector。将新连接的 SocketChannel 配置为非阻塞的
            //而且由于接受这个连接的目的是为了读取来自套接字的数据，所以我们还必须将 SocketChannel 注册到 Selector上
            SelectionKey newKey = sc.register(selector,SelectionKey.OP_READ);
            System.out.println("Got connection from " + sc);

            //将key对应Channel设置为准备接受其他请求
            //key.interestOps(SelectionKey.OP_ACCEPT);

        } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
            // Read the data
            SocketChannel sc = (SocketChannel) key.channel();
            // Echo data
            int bytesEchoed = 0;
            while (true) {
                echoBuffer.clear();
                int r = sc.read(echoBuffer);
                //System.out.println(r);
                if (r <= 0) {
                    break;
                }
                echoBuffer.flip();
                System.out.println("收到：" + CharsetHelper.decode(echoBuffer));
                echoBuffer.flip();
                sc.write(echoBuffer);
                bytesEchoed += r;
            }
            echoBuffer.clear();
            System.out.println("Echoed " + bytesEchoed + " from " + sc);

            // 写完就把状态关注去掉，否则会一直触发写事件(改变自身关注事件)
            //key.interestOps(SelectionKey.OP_READ);
        }
    }

    private Selector getSelector() throws IOException {
        // 1. 创建一个selector，select是NIO中的核心对象
        // 它用来监听各种感兴趣的IO事件
        Selector selector = Selector.open();

        // 为每个端口打开一个监听, 并把这些监听注册到selector中
        for (int port : ports) {
            //2. 打开一个ServerSocketChannel
            //其实我们没监听一个端口就需要一个channel
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);//设置为非阻塞

            // 绑定通道到指定端口
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            ss.bind(address);//监听一个端口

            //3. 注册到selector
            //register的第一个参数永远都是selector
            //第二个参数是我们要监听的事件
            //OP_ACCEPT是新建立连接的事件
            //也是适用于ServerSocketChannel的唯一事件类型
            //
            SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Going to listen on " + port);
        }
        return selector;
    }

    public static void main(String args2[]) throws Exception {
        String args[]={"9001","9002","9003"};
        if (args.length <= 0) {
            System.err.println("Usage: java MultiPortEcho port [port port ...]");
            System.exit(1);
        }
        int ports[] = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            ports[i] = Integer.parseInt(args[i]);
        }
        new MultiPortEcho(ports);
    }
}
