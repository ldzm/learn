package com.github.ldzm.io.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.locks.LockSupport;

public class SimulateDelayClientBIO implements Runnable {
    public static final int SLEEP_TIME = 1000 * 1000 * 1000;

    private Socket client;
    private PrintWriter out = null;

    @Override
    public void run() {
        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 9001));
            out = new PrintWriter(client.getOutputStream(), true);

            out.print("H");
            out.println();
            out.flush();
            LockSupport.parkNanos(SLEEP_TIME);
            out.print("e");
            LockSupport.parkNanos(SLEEP_TIME);
            out.print("l");
            LockSupport.parkNanos(SLEEP_TIME);
            out.print("l");
            LockSupport.parkNanos(SLEEP_TIME);
            out.print("o");
            LockSupport.parkNanos(SLEEP_TIME);
            out.print("!");
            LockSupport.parkNanos(SLEEP_TIME);
            out.println();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            out.close();
        }
    }

    public static void main(String[] args) {
        new Thread(new SimulateDelayClientBIO()).start();
    }
}
