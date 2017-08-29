package com.github.ldzm.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelTest {

    // 异步文件读写示例
    public static void asyFile() {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        String encoding = System.getProperty("file.encoding");
        Path path = Paths.get("/tmp", "store.txt");
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

            // 使用CompletionHandler回调接口异步读取文件
            final Thread current = Thread.currentThread();
            asynchronousFileChannel.read(buffer, 0,
                    "Read operation status ...",
                    new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {
                            System.out.println(attachment);
                            System.out.print("Read bytes: " + result);
                            current.interrupt();
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println(attachment);
                            System.out.println("Error:" + exc);
                            current.interrupt();
                        }
                    });

        } catch (Exception ex) {
            System.err.println(ex);
        }
        buffer.flip();
        System.out.print(Charset.forName(encoding).decode(buffer));
        buffer.clear();

        // 异步文件写示例
        ByteBuffer buffer1 = ByteBuffer
                .wrap("The win keeps Nadal at the top of the heap in men's"
                        .getBytes());
        Path path1 = Paths.get("/tmp", "store.txt");
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel
                .open(path1, StandardOpenOption.WRITE)) {
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

}
