package com.github.ldzm.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Stjk {

    static class Node {
        int x;
        int y;
        int w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        final int NUMBS = 1001;

        int [][] matrix = new int[NUMBS][NUMBS];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        ArrayList<Node> list = new ArrayList<>(NUMBS);
        for(int i = 0; i < n; i++) {

            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();

            Node node = new Node(x, y, w);
            list.add(node);

            matrix[x][y] = w;

            if(x < minX) {
                minX = x;
            }
            if(x > maxX) {
                maxX = x;
            }
            if(y < minY) {
                minY = y;
            }
            if(y > maxY) {
                maxY = y;
            }
        }


        int minSum = Integer.MAX_VALUE;
        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                int currentSum = 0;
                for(Node node : list) {
                    currentSum += (Math.abs(node.x - i) + Math.abs(node.y - j)) * node.w;
                }
                if (currentSum < minSum) {
                    minSum = currentSum;
                }
            }
        }

        System.out.println(minSum);
    }
}
