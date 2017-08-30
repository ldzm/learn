package com.github.ldzm.io.aio;

import com.github.ldzm.commom.CharsetHelper;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.charset.CharacterCodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelTest {

    private static ByteBuffer buffer = ByteBuffer.allocate(100);

    // 异步文件读示例
    public static void asynchronousReadFile(String directory, String file) {

        Path path = Paths.get(directory, file);
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel
                .open(path, StandardOpenOption.READ)) {
            Future<Integer> result = asynchronousFileChannel.read(buffer, 0);
            // 读超时控制
            // int count = result.get(100, TimeUnit.NANOSECONDS);

            while (!result.isDone()) {
                System.out.println("Do something else while reading ...");
            }
            System.out.println("Read done: " + result.isDone());
            System.out.println("Bytes read: " + result.get());

        } catch (Exception ex) {
            System.err.println(ex);
        }
        buffer.flip();
        try {
            System.out.print(CharsetHelper.decode(buffer));
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        buffer.clear();
    }

    public static void asynchronousReadFileByCompletionHandler(String directory, String file) {
        // 使用CompletionHandler回调接口异步读取文件

        System.out.println("main thread id:" + Thread.currentThread().getId());
        Path path = Paths.get(directory, file);
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel
                .open(path, StandardOpenOption.READ)) {

            // 使用CompletionHandler回调接口异步读取文件
            final Thread current = Thread.currentThread();
            asynchronousFileChannel.read(buffer, 0,
                    "Read operation status ...",
                    new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {
                            System.out.println(attachment);
                            System.out.println("Read bytes: " + result + " H");
                            System.out.println("read thread id:" + Thread.currentThread().getId());
                            //current.interrupt();
                            System.out.println("H");
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println(attachment);
                            System.out.println("Error:" + exc);
                            //current.interrupt();
                        }
                    });

        } catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buffer.flip();
        try {
            System.out.print(CharsetHelper.decode(buffer));
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        buffer.clear();
    }

    // 异步文件写示例
    public static void asynchronousWriteFile(String directory, String file) {
        // 异步文件写示例
        ByteBuffer buffer1 = ByteBuffer
                .wrap("The win keeps Nadal at the top of the heap in men's"
                        .getBytes());
        Path path = Paths.get(directory, file);
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel
                .open(path, StandardOpenOption.WRITE)) {
            Future<Integer> result = asynchronousFileChannel
                    .write(buffer1, 100);
            while (!result.isDone()) {
                System.out.println("Do something else while writing ...");
            }
            System.out.println("Written done: " + result.isDone());
            System.out.println("Bytes written: " + result.get());

            // file lock
            Future<FileLock> featureLock = asynchronousFileChannel.lock();
            System.out.println("Waiting for the file to be locked ...");
            FileLock lock = featureLock.get();
            if (lock.isValid()) {
                Future<Integer> featureWrite = asynchronousFileChannel.write(
                        buffer, 0);
                System.out.println("Waiting for the bytes to be written ...");
                int written = featureWrite.get();
                // or, use shortcut
                // int written = asynchronousFileChannel.write(buffer,0).get();
                System.out.println("I’ve written " + written + " bytes into "
                        + path.getFileName() + " locked file!");
                lock.release();
            }

            // asynchronousFileChannel.lock("Lock operation status:", new
            // CompletionHandler<FileLock, Object>() ;

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {

        //asynchronousReadFile("F:\\", "store.txt");
        asynchronousReadFileByCompletionHandler("F:\\", "store.txt");
        asynchronousWriteFile("F:\\", "store.txt");
    }
}
