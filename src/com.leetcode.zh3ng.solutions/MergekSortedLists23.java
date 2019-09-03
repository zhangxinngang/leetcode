package com.leetcode.zh3ng.solutions;

import model.ListNode;

/*
 * created by zhangxingang on 2019/08/08
 *
 *
 * 用快排也行其实，这么做有点low了
 */
public class MergekSortedLists23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
        head.next = tail;
        ListNode minNode = getMinNode(lists);
        while(minNode != null){
            tail.next = minNode;
            tail = tail.next;
            minNode = getMinNode(lists);
        }
        return head.next.next;
    }

    public static ListNode getMinNode(ListNode[] lists){
        ListNode minNode = null;
        ListNode minList = null;
        int minIndex = 0;
        for (int i = 0;i<lists.length;i++){
            ListNode listNode = lists[i];
            if (listNode == null){
                continue;
            }
            if (minNode == null){
                minNode = new ListNode(listNode.val);
                minList = listNode;
                minIndex = i;
                continue;
            }
            if (listNode.val < minNode.val){
                minNode = new ListNode(listNode.val);
                minList = listNode;
                minIndex = i;
            }
        }
        if (minNode == null){
            return null;
        }
        minList = minList.next;
        lists[minIndex] = minList;
        return minNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = l2;
        ListNode l3 = new ListNode(2);
        l2.next = l3;

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        n1.next = n2;
        ListNode n3 = new ListNode(5);
        n2.next = n3;

        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(6);
        m1.next = m2;
        ListNode m3 = new ListNode(8);
        m2.next = m3;

        ListNode[] lists = new ListNode[]{l1,n1,m1};

        ListNode n = mergeKLists(lists);

        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
