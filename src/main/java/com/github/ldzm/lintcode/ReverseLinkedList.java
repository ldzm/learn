package com.github.ldzm.lintcode;

public class ReverseLinkedList {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = curNode.next;

        while(curNode != null) {

            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }
}
