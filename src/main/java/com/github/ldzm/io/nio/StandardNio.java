package com.github.ldzm.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 代码来自博客：http://blog.csdn.net/suifeng3051/article/details/48160753
 * 感谢博主的无私奉献
 */
public class StandardNio {

    public static void copyFileUseNio(String src, String dst)  throws IOException{

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        // 获得传输通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fileInputStream = new FileInputStream(new File(src));
            fileOutputStream = new FileOutputStream(new File(dst));

            // 获得传输通道
            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

            // 获取buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {

                int eof = inChannel.read(buffer);
                // 判断是否读完文件
                if (eof == -1) {
                    break;
                }

                // 重新设置buffer的position=0，limit=position
                buffer.flip();

                outChannel.write(buffer);

                // 写完后重置buffer，position=0, limit=capacity
                buffer.clear();
            }
        } finally {
            inChannel.close();
            outChannel.close();

            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static void main(String[] args) {
        try {
            StandardNio.copyFileUseNio("E:\\infile.txt", "E:\\outfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
