package com.leetcode.zh3ng.solutions;

import model.ListNode;


public class RotateList61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode trueHead = new ListNode(0);
        trueHead.next = head;
        for (int i = 0;i<k;i++){
            ListNode tailFormer = trueHead;
            ListNode tail = trueHead.next;
            while (tail.next != null){
                tailFormer = tail;
                tail = tail.next;
            }
            rotate(trueHead,tailFormer);
        }
        return trueHead.next;
    }

    //求链表长度，直接找到阶段的头结点，带着整个的后继移动到head.next
    public static ListNode solution2(ListNode head, int k){
        if (head == null||head.next == null){
            return head;
        }
        ListNode trueHead = new ListNode(0);
        trueHead.next = head;
        int count = 1;
        ListNode tail = trueHead.next;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        if (count < k){
            k = k%count;
        }
        ListNode tailFormer = trueHead;
        for (int i = 0;i < count-k;i++){
            tailFormer = tailFormer.next;
        }
        tail.next = trueHead.next;
        trueHead.next = tailFormer.next;
        tailFormer.next = null;

        return trueHead.next;
    }

    public static void rotate(ListNode trueHead,ListNode tailFormer){
        tailFormer.next.next  = trueHead.next;
        trueHead.next = tailFormer.next;
        tailFormer.next = null;
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

        ListNode result = solution2(n1,3);//rotateRight(n1,7);

        System.out.println("sdfdsfs");
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
