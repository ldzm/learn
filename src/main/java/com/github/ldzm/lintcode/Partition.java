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
        while(current != null) {
            if(current.val >= x) {
                break;
            }
            small = current;
            preCurrent = current;
            current = current.next;
        }

        while(current != null) {
            if(current.val < x) {
                current = current.next;

                if(small == null) {
                    small = preCurrent.next;
                    small.next = head;
                    head = small; // head赋值为small的地址，但是参数中的head的值不会变（引用的传值），所以必须用返回值来传递结果

                } else  {
                    ListNode temp = small.next;
                    small.next = preCurrent.next;
                    small.next.next = temp;
                    small = small.next;
                }

                preCurrent.next = current;
            } else {
                preCurrent = current;
                current = current.next;
            }
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

        head = new Partition().partition(head, 3);

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

        head2 = new Partition().partition(head2, 3);

        current = head2;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
