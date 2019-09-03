package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class MergeTwoSortedLists21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode resultTail = new ListNode(0);
        resultHead.next = resultTail;
        while (l1 != null&&l2 != null){
            if (l1.val < l2.val){
                resultTail.next = l1;
                l1 = l1.next;
            }else {
                resultTail.next = l2;
                l2 = l2.next;
            }
            resultTail = resultTail.next;
        }
        if (l1 == null){
            resultTail.next = l2;
        }else{
            resultTail.next = l1;
        }
        return resultHead.next.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(8);
        n3.next = n4;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(5);
        m1.next = m2;
        ListNode m3 = new ListNode(7);
        m2.next = m3;

        ListNode result = mergeTwoLists(n1,m1);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
