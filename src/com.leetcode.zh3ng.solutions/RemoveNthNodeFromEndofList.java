package com.leetcode.zh3ng.solutions;

import model.ListNode;

/*
 * created by zhangxingang on 2019/08/08
 */
public class RemoveNthNodeFromEndofList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //head include
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nhead = new ListNode(0);
        nhead.next = head;
        reverse(nhead);

        ListNode p = nhead.next;
        ListNode forhead = nhead;
        for (int i=1;i<n;i++){
            p = p.next;
            forhead = forhead.next;
        }
        System.out.println("forhead"+forhead);
        System.out.println("p"+p);
        forhead.next = p.next;
        reverse(nhead);
        return nhead.next;
    }

    static ListNode node;

    public static void deleteNode(ListNode head) {
        ListNode pre = head;
        while(pre.next.val != node.val){
            pre = pre.next;
        }
        ListNode p = pre.next;
        pre.next = p.next;
    }


    //head not include
    public static void reverse(ListNode head){
        if (head == null||head.next ==null||head.next.next == null){
            return;
        }
        ListNode p = head.next.next;
        head.next.next = null;
        while(p != null){
            ListNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
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

        //ListNode n = removeNthFromEnd(n1,3);
        node = new ListNode(3);
        deleteNode(n1);
        ListNode n = n1;
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
