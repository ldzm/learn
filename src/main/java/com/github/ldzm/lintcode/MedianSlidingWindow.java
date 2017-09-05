package com.github.ldzm.lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
    /**
     * @param numbs: A list of integers
     * @param k:    An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] numbs, int k) {
        // write your code here

        List<Integer> result = new ArrayList<>(8);

        // 最大堆存小于中位数的值
        PriorityQueue<Integer> max = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 默认是最小堆， 最小堆存大于中位数的值
        PriorityQueue<Integer> min = new PriorityQueue<>(k);

        for(int i = 0; i < numbs.length; i++) {

            int temp = numbs[i];
            // 索引为偶数的数据插入最大堆
            if((i & 1) == 0) {
                if(max. size() == (k + 1) / 2) {
                    max.remove(numbs[i - k]);
                }
                // 如果最小堆不为空，并且numb[i]大于最小堆的堆顶，则插入最小堆，获取最小堆的堆顶
                if (min.size() > 0 && temp > min.peek()) {
                    min.offer(temp);
                    temp = min.poll();
                }

                // 把数据插入最大堆
                max.offer(temp);

            } else {
                // 索引为偶数的数据插入最小堆
                if(min. size() == k / 2) {
                    min.remove(numbs[i - k]);
                }

                // 如果最大堆不为空，并且numb小于最大堆的堆顶，则插入最大堆，获取最大堆的堆顶
                if(max.size() > 0 && temp < max.peek()) {
                    max.offer(temp);
                    temp = max.poll();
                }

                // 把数据插入最小堆
                min.offer(temp);
            }

            int median = 0;
            if((k & 1) == 0) {
                median = (max.peek() + min.peek()) / 2;
            } else {
                median = max.peek();
            }
            result.add(median);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] numbs = {1,2,7,8,5};
        int k = 3;
        List<Integer> result = new MedianSlidingWindow().medianSlidingWindow(numbs, k);
        for(int r : result) {
            System.out.println(r);
        }
    }
}
