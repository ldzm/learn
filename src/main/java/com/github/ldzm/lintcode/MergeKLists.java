package com.github.ldzm.lintcode;

import java.util.List;

public class MergeKLists {

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here

        if(lists == null) {
            return null;
        }

        if(lists.size() == 0) {
            return  null;
        }

        return partition(lists, 0, lists.size() - 1);
    }

    ListNode partition(List<ListNode> lists, int start , int end) {
        if(start == end) {
            return lists.get(start);
        }

        if(start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }

        return null;
    }

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
}
