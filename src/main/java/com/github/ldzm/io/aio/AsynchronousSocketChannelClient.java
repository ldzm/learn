package com.github.ldzm.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class AsynchronousSocketChannelClient {

    public static void main(String[] args) {
        AsynchronousSocketChannel client = null;
        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 写localhost是因为服务端也在本地电脑，正常此处的应该写服务端的ip地址和服务端监听的端口
        try {
            Void connect = client.connect(new InetSocketAddress("localhost", 9002)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        while (true) {

            Scanner in = new Scanner(System.in);
            String content = in.nextLine();
            ByteBuffer message = ByteBuffer.wrap(content.getBytes());
            try {
                client.write(message).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
