package com.leetcode.zh3ng.solutions;

import model.ListNode;

/*
 * created by zhangxingang on 2019/08/08
 */
public class ReverseNodesinkGroup {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultHead = new ListNode(0);
        ListNode resultTail = new ListNode(0);
        resultHead.next = resultTail;

        ListNode listtail = new ListNode(0);
        ListNode listhead = new ListNode(0);
        listhead.next = listtail;
        int count = 0;
        while (head != null){
            listtail.next = new ListNode(head.val);
            listtail = listtail.next;
            count += 1;
            if (count == k){
                ListNode list = reverse(listhead.next.next);
                resultTail.next = list;
                resultTail = listhead.next.next;
                count = 0;
                listtail = new ListNode(0);
                listhead = new ListNode(0);
                listhead.next = listtail;
            }
            head = head.next;
        }

        resultTail.next = listhead.next.next;
        return resultHead.next.next;
    }

    //这里返回的不带头结点
    public static ListNode reverse(ListNode head){
        ListNode h = new ListNode(0);
        h.next = head;
        if (h.next.next == null || h.next == null){
            return h.next;
        }
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

        ListNode n = reverseKGroup(n1,3);

        System.out.println("      ");
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }

    }
}
