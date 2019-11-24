package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class ReorderList143 {
    //todo unsolved
    public static void reorderList(ListNode head) {
        int len = len(head);
        if (len <= 2){
            return;
        }
        int half = len%2==0?len/2:len/2+1;

        ListNode secondHalfNode;
        ListNode h = head;
        for (int i = 0;i<half;i++){
            h = h.next;
        }
        secondHalfNode = h;
        ListNode reverse = reverse(halfNode);
        ListNode result = new ListNode(0);
        while(head != null || halfNode != null){
            if (halfNode != null){
                head.next = halfNode;
            }
        }


    }

    public static ListNode reverse(ListNode head){
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h.next.next;
        h.next.next = null;
        while(p != null){
            ListNode q = p.next;
            p.next = h.next;
            h.next = p;
            p = q;
        }
        return h.next;
    }

    public static int len(ListNode head){
        if (head == null){
            return 0;
        }
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(6);
        n5.next = n6;

        ListNode n = reverse(n1);

        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
