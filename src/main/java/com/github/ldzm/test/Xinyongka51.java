package com.github.ldzm.test;

import java.util.*;

/**
 *
 1 2 3 3 1 2 2
 2 1 1 1 1 1 1
 */
public class Xinyongka51 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //int [] condidate = new int[10001];

        ArrayList<Integer> list = new ArrayList<>(10240);
        while(in.hasNext()) {
            list.add(in.nextInt());
        }

        int length = list.size() / 2;

        HashMap<Integer, Node> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            int key = list.get(i);
            if(map.get(key) != null) {
                Node node = map.get(key);
                node.w = node.w + list.get(length + i);
                node.count += 1;
                map.put(key, node);
            } else {
                Node node = new Node(key, list.get(length + i), 1);
                map.put(key, node);
            }
        }

        List<Node> nodes = new ArrayList<>();
        for(Node node : map.values()) {
            nodes.add(node);
        }

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.w < o2.w) {
                    return 1;
                } else if(o1.w == o2.w) {
                    if(o1.count < o2.count) {
                        return 1;
                    } else if(o1.count == o2.count){
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        };
        nodes.sort(comparator);

        System.out.println(nodes.get(0).i);
    }
}
class Node {
    int i;
    int w;
    int count;

    public Node(int i, int w, int count) {
        this.i = i;
        this.w = w;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "i=" + i +
                ", w=" + w +
                ", count=" + count +
                '}';
    }
}