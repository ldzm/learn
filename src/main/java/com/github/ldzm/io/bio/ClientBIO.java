package com.github.ldzm.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientBIO {
    public static void main(String[] args) {
        Socket client;

        PrintWriter out = null;
        BufferedReader in = null;

        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 9001));
            out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello!");

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("从服务器读取数据：" + in.readLine());

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
