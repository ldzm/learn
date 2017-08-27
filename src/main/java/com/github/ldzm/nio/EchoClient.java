package com.github.ldzm.nio;

import com.github.ldzm.commom.CharsetHelper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int port = in.nextInt();

        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost", port));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);

        while(true){
            selector.select();
            Iterator ite = selector.selectedKeys().iterator();
            while(ite.hasNext()){
                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();

                if(key.isConnectable()){
                    if(channel.isConnectionPending()){
                        if(channel.finishConnect()){
                            key.interestOps(SelectionKey.OP_READ);

                            channel.write(CharsetHelper.encode(CharBuffer.wrap("Hello")));
                            System.out.println("连接成功！");
                        }
                        else{
                            key.cancel();
                        }
                    }
                }
                else if(key.isReadable()){

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    channel.read(byteBuffer);
                    byteBuffer.flip();
                    CharBuffer charBuffer = CharsetHelper.decode(byteBuffer);
                    System.out.println(charBuffer.toString());

                    Scanner in2 = new Scanner(System.in);
                    String input = in2.nextLine();
                    channel.write(CharsetHelper.encode(CharBuffer.wrap(input)));
                }
            }
        }
    }
}
