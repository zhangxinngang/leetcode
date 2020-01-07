package com.leetcode.zh3ng.solutions;

import model.ListNode;

/*
 * created by zhangxingang on 2020/01/07
 */
public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = head;
        ListNode prev = h;
        while(p != null&&p.next != null){
            ListNode next = p.next;
            p.next = next.next;
            next.next = p;
            prev.next = next;
            prev = p;
            p = p.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);



        System.out.println(head.getVal());
        System.out.println(head.next.getVal());
        System.out.println(head.next.next.getVal());
        System.out.println(head.next.next.next.getVal());
        System.out.println(head.next.next.next.next.getVal());
        System.out.println(head.next.next.next.next.next.getVal());


        System.out.println("---------");
        SwapNodesInPairs24 swapNodesInPairs = new SwapNodesInPairs24();
        ListNode h = swapNodesInPairs.swapPairs(head);

        System.out.println("---------");

        System.out.println(h.getVal());
        System.out.println(h.next.getVal());
        System.out.println(h.next.next.getVal());
        System.out.println(h.next.next.next.getVal());
        System.out.println(h.next.next.next.next.getVal());
        System.out.println(h.next.next.next.next.next.getVal());

    }
}
