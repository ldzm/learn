package com.github.ldzm.lintcode;

/**
 * 给定一个链表，判断它是否有环。
 */
public class HasCycle {

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     * 一个节点是否可以形成环？？？
     */
    public boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {

            if(fast.next == null) {
                return false;
            }
            fast = fast.next.next;

            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
