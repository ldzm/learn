package com.github.ldzm.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.*;

public class AsynchronousServerSocketChannelTest {

    //异步server socket channel io处理示例
    public static void asyServerSocketChannel() {

        //使用threadGroup
//      AsynchronousChannelGroup threadGroup = null;
//      ExecutorService executorService = Executors
//      .newCachedThreadPool(Executors.defaultThreadFactory());
//      try {
//      threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
//      } catch (IOException ex) {
//      System.err.println(ex);
//      }
//      AsynchronousServerSocketChannel asynchronousServerSocketChannel =
//              AsynchronousServerSocketChannel.open(threadGroup);

        final int DEFAULT_PORT = 5555;
        final String IP = "127.0.0.1";
        ExecutorService taskExecutor = Executors.newCachedThreadPool(Executors
                .defaultThreadFactory());
        // create asynchronous server socket channel bound to the default group
        try (AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel
                .open()) {
            if (asynchronousServerSocketChannel.isOpen()) {
                // set some options
                asynchronousServerSocketChannel.setOption(
                        StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                asynchronousServerSocketChannel.setOption(
                        StandardSocketOptions.SO_REUSEADDR, true);
                // bind the server socket channel to local address
                asynchronousServerSocketChannel.bind(new InetSocketAddress(IP,
                        DEFAULT_PORT));
                // display a waiting message while ... waiting clients
                System.out.println("Waiting for connections ...");
                while (true) {
                    Future<AsynchronousSocketChannel> asynchronousSocketChannelFuture = asynchronousServerSocketChannel.accept();
                    //使用CompletionHandler来处理IO事件
//                  asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>()
                    //client使用CompletionHandler来处理IO事件
                    //asynchronousSocketChannel.connect(new InetSocketAddress(IP, DEFAULT_PORT), null,new CompletionHandler<Void, Void>()
                    try {
                        final AsynchronousSocketChannel asynchronousSocketChannel = asynchronousSocketChannelFuture
                                .get();
                        Callable<String> worker = new Callable<String>() {
                            @Override
                            public String call() throws Exception {
                                String host = asynchronousSocketChannel.getRemoteAddress().toString();
                                System.out.println("Incoming connection from: "
                                        + host);
                                final ByteBuffer buffer = ByteBuffer
                                        .allocateDirect(1024);
                                // transmitting data
                                while (asynchronousSocketChannel.read(buffer)
                                        .get() != -1) {
                                    buffer.flip();
                                }
                                asynchronousSocketChannel.write(buffer).get();
                                if (buffer.hasRemaining()) {
                                    buffer.compact();
                                } else {
                                    buffer.clear();
                                }
                                asynchronousSocketChannel.close();
                                System.out.println(host
                                        + " was successfully served!");
                                return host;
                            }
                        };
                        taskExecutor.submit(worker);
                    } catch (InterruptedException | ExecutionException ex) {
                        System.err.println(ex);
                        System.err.println("\n Server is shutting down ...");
                        // this will make the executor accept no new threads
                        // and finish all existing threads in the queue
                        taskExecutor.shutdown();
                        // wait until all threads are finished
                        while (!taskExecutor.isTerminated()) {
                        }
                        break;
                    }
                }
            } else {
                System.out
                        .println("The asynchronous server-socket channel cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
