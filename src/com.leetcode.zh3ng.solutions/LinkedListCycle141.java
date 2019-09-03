package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class LinkedListCycle141 {
    public static boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
//        ListNode n3 = new ListNode(3);
//        n2.next = n3;
//        ListNode n4 = new ListNode(4);
//        n3.next = n4;
//        n4.next = n2;
        n2.next = n1;

        boolean p = hasCycle(n1);
        System.out.println(p);
    }
}
