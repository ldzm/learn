package com.github.ldzm.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 为每一个客户端使用一个线程，如果客户端出现延时等异常，线程可能会被占用很长时间。因为数据的准备和读取都在这个线程中。
 * 此时，如果客户端数量众多，可能会消耗大量的系统资源。
 * 使用线程池解决了线程创建和销毁所需要的时间开销，不能解决上面的问题
 */
public class EchoServerBIO {

    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        Executor executor = Executors.newFixedThreadPool(10);

        try {
            echoServer = new ServerSocket(9001);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {

            try {
                // 等待客户端连接
                clientSocket = echoServer.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("客户端：" + clientSocket.getRemoteSocketAddress() + "链接成功");
            executor.execute(new HandleMessage(clientSocket));
        }
    }
}

class HandleMessage implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public HandleMessage(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            long startTime = System.currentTimeMillis();

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Hello!");
                out.println(inputLine);
            }
            long endTime = System.currentTimeMillis();

            System.out.println("花费时间：" + (endTime - startTime) + " ms");
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}