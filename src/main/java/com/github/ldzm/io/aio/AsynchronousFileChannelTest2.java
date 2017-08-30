package com.github.ldzm.io.aio;

import com.github.ldzm.commom.CharsetHelper;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.*;

public class AsynchronousFileChannelTest2 {
    // public static AsynchronousFileChannel open(Path file, Set<? extends
    // OpenOption> options,ExecutorService executor, FileAttribute<?>... attrs)
    // throws IOException
    private static Set withOptions() {
        final Set options = new TreeSet<>();
        options.add(StandardOpenOption.READ);
        return options;
    }

    // 使用AsynchronousFileChannel.open(path, withOptions(),
    // taskExecutor))这个API对异步文件IO的处理
    public static void asynchronousFileChannel(String directory, String file) {
        final int THREADS = 5;
        ExecutorService taskExecutor = Executors.newFixedThreadPool(THREADS);

        List<Future<ByteBuffer>> list = new ArrayList<>();
        int sheeps = 0;
        Path path = Paths.get(directory,file);
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel
                .open(path, withOptions(), taskExecutor)) {
            for (int i = 0; i < 50; i++) {
                Callable<ByteBuffer> worker = new Callable<ByteBuffer>() {
                    @Override
                    public ByteBuffer call() throws Exception {
                        ByteBuffer buffer = ByteBuffer
                                .allocateDirect(ThreadLocalRandom.current()
                                        .nextInt(100, 200));
                        asynchronousFileChannel.read(buffer, ThreadLocalRandom
                                .current().nextInt(0, 100));
                        return buffer;
                    }
                };
                Future<ByteBuffer> future = taskExecutor.submit(worker);
                list.add(future);
            }
            // this will make the executor accept no new threads
            // and finish all existing threads in the queue
            taskExecutor.shutdown();
            // wait until all threads are finished
            while (!taskExecutor.isTerminated()) {
                // do something else while the buffers are prepared
                System.out
                        .println("Counting sheep while filling up some buffers!So far I counted: "
                                + (sheeps += 1));
            }
            System.out.println("\nDone! Here are the buffers:\n");
            for (Future<ByteBuffer> future : list) {
                ByteBuffer buffer = future.get();
                System.out.println("\n\n" + buffer);
                System.out.println("______________________________________________________");
                buffer.flip();
                System.out.print(CharsetHelper.decode(buffer));
                buffer.clear();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        asynchronousFileChannel("F:\\", "store.txt");
    }
}
