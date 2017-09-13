package com.github.ldzm.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListLinkedListPerfermenceTest {

    public static final int NUMBS = 100000;
    public static void main(String[] args) {
        // 测试ArrayList查找index对应值的效率
        // 所有随机函数的范围是[0,NUMBS)

        Long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < NUMBS; i++) {
            arrayList.add(i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("ArrayList添加" + NUMBS + "个元素所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < NUMBS; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList添加" + NUMBS + "个元素所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //arrayList.get(index);
            arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList随机查询" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //linkedList.get(index);
            linkedList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList随机查询" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //arrayList.indexOf(index);
            arrayList.indexOf(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("随机查找ArrayList中某个值" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //linkedList.indexOf(index);
            linkedList.indexOf(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("随机查找LinkedList中某个值" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //arrayList.set(index, index);
            arrayList.set(i, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList随机插入" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            //int index = (int)(Math.random() * NUMBS);
            //linkedList.set(index, index);
            linkedList.set(i, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList随机插入" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            int index = (int)(Math.random() * arrayList.size());
            arrayList.remove(index);
            //arrayList.remove(NUMBS - i - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList随机删除" + NUMBS + "次所需要的时间" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < NUMBS; i++) {
            int index = (int)(Math.random() * linkedList.size());
            linkedList.remove(index);
            //linkedList.remove(NUMBS - i - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList随机删除" + NUMBS + "次所需要的时间" + (endTime - startTime));
    }
}
