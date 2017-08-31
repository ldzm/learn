package com.github.ldzm.lintcode;

public class MergeTwoLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return  l1;
        }

        ListNode head = null;
        ListNode current = null;
        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                if(head == null) {
                    head = current = l1;
                } else {
                    current.next = l1;
                    current = current.next;
                }
                l1 = l1.next;
            } else {
                if(head == null) {
                    head = current = l2;
                } else {
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }

        if(l1 == null) {
            current.next = l2;
        }

        if(l2 == null) {
            current.next = l1;
        }

        return head;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return  l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }
}
