package com.github.ldzm.lintcode;

import java.util.LinkedList;

public class MinStack {

    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> min = new LinkedList<Integer>();

    public MinStack() {
        // do initialize if necessary
    }

    public void push(int number) {

        stack.addFirst(number);
        if(min.isEmpty()) {
            min.addFirst(number);
        } else if(min.peekFirst() >= number){
            min.addFirst(number);
        } else {
            min.addFirst(min.peekFirst());
        }
    }

    public int pop() {

        min.removeFirst();
        return stack.removeFirst();
    }

    public int min() {
        return min.peekFirst();
    }
}
