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

        ListNode small = null;
        ListNode preCurrent = null;
        ListNode current = head;
        while (current != null) {

            if(current.val <= x) {
                if(small == null) {
                    small = head;
                } else {
                    small = small.next;
                }
                if(small != current) {
                    int temp = small.val;
                    small.val = current.val;
                    current.val = temp;
                }
            }

            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(2);

        current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        new Partition().partition(head, 3);

        current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        ListNode head2 = new ListNode(3);
        current = head2;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(1);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(4);

        current = head2;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        new Partition().partition(head2, 3);

        current = head2;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
