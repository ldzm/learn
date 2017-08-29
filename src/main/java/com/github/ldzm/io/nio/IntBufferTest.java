package com.github.ldzm.io.nio;

import java.nio.IntBuffer;

public class IntBufferTest {
    public static void main(String[] args) {
        // 分配新的int缓冲区，参数为缓冲区容量
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
        IntBuffer buffer = IntBuffer.allocate(8);

        for (int i = 0; i < buffer.capacity() - 1; ++i) {
            int j = 2 * (i + 1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            buffer.put(j);
        }

        // before flip(): position 7 limit 8
        System.out.println("before flip(): position " + buffer.position() + " limit " + buffer.limit());
        // 重设此缓冲区，将限制设置为当前位置（limit = 7），然后将当前位置设置为0（position = 0）
        buffer.flip();
        // after flip(): position 0 limit 7
        System.out.println("after flip(): position " + buffer.position() + " limit " + buffer.limit());

        // 查看在当前位置和限制位置之间是否有元素
        while (buffer.hasRemaining()) {
            // 读取此缓冲区当前位置的整数，然后当前位置递增
            int j = buffer.get();
            System.out.print(j + "  ");
        }

        // before clear(): position 7 limit 7
        System.out.println("\nbefore clear(): position " + buffer.position() + " limit " + buffer.limit());
        buffer.clear();
        // after clear(): position 0 limit 8
        System.out.println("after clear(): position " + buffer.position() + " limit " + buffer.limit());
    }
}
