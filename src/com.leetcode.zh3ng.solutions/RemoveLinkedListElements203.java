package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class RemoveLinkedListElements203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode listhead = new ListNode(0);
        ListNode listTail = new ListNode(0);
        listhead.next = listTail;
        listTail.next = head;
        while (listTail.next != null){
            System.out.println(listTail.val);
            if (listTail.next.val == val){
                listTail.next = listTail.next.next;
            }else{
                listTail = listTail.next;
            }
        }
        return listhead.next.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(8);
        n3.next = n4;
        ListNode n5 = new ListNode(3);
        n4.next = n5;
        ListNode n6 = new ListNode(9);
        n5.next = n6;

        ListNode result = removeElements(n1,3);
        System.out.println("sdfdsfs");
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
