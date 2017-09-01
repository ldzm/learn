package com.github.ldzm.lintcode;

public class AddLists {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode current = null;
        ListNode head = null;

        int temp = 0;

        while(l1 != null && l2 != null) {
            temp = l1.val + l2.val + temp / 10;

            l1.val = temp % 10;
            if(current == null) {
                head = current = l1;
            } else {
                current.next = l1;
                current = current.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        // 计算l2剩余的数
        if (l1 == null && l2 != null) {

            temp = l2.val + temp / 10;
            l2.val = temp % 10;

            while(l2 != null) {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        // 计算l1剩余的数
        if (l2 == null && l1 != null) {

            temp = l1.val + temp / 10;
            l1.val = temp % 10;
            while(l1 != null) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
        }

        // 最后一个数如果有进位必须new一个节点
        if (l1 == null && l2 == null && (temp / 10 == 1)) {
            current.next = new ListNode(1);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head;
        ListNode current = head = new ListNode(9);
        current.next = new ListNode(9);

        //current = current.next;
        //current.next = new ListNode(5);

        ListNode head2;
        current = head2 = new ListNode(9);
        //current.next = new ListNode(9);
        //current = current.next;
        //current.next = new ListNode(4);

        current = new AddLists().addLists(head, head2);

        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int x) {
        val = x;
        next = null;
    }
}