package com.github.ldzm.lintcode;

public class Partition {
    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here

        if(head == null) {
            return null;
        }

        int index = 0;

        ListNode current = head;
        while(current != null) {
            if(current.val == x) {
                break;;
            }

            index++;
            current = current.next;
        }

        ListNode small = null;
        ListNode end = null;
        current = head;
        while (current != null) {

            if(current.val < x)
            if(small == null) {
                small = end = current;
            }

        }
    }
}
