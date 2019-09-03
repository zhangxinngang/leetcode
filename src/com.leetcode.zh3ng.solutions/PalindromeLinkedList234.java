package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        int count = getLength(head);
        System.out.println("count"+count);
        ListNode l1 = new ListNode(0);
        l1.next = head;
        ListNode l2 = new ListNode(0);
        if (count == 1){
            return true;
        }

        int cnt = 0;
        while (head != null){
            System.out.println("cnt:"+cnt);
            if (cnt == count/2-1){
                l2.next = head.next;
                head.next = null;
                break;
            }
            cnt += 1;
            head = head.next;
        }
        System.out.println("sublist cnt:"+getLength(l1));
        System.out.println("sublist cnt:"+getLength(l2));
        reverse(l2);

        while (l1!=null){
            System.out.println(l1.val+" "+l2.val);
            if (l1.val != l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void reverse(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
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

    public static int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count += 1;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
//        n3.next = n4;
//        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        n3.next = n5;
        ListNode n6 = new ListNode(1);
        n5.next = n6;

        System.out.println(isPalindrome(n1));
    }
}
