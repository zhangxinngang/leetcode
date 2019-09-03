package com.leetcode.zh3ng.solutions;/*
 * created by zhangxingang on 2019/08/06
 */

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class CycleII {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode p = head;
        Set<ListNode> reachedSetc = new HashSet<>();
        while(p != null){
            System.out.println(p.val);
            if (reachedSetc.contains(p)){
                return p;
            }
            reachedSetc.add(p);
            p = p.next;
        }
        return null;
    }

    /**
     * @method
     * @date 2019-08-07 14:26
     * @author zhangxingang
     * @description
     *
     * public ListNode detectCycle(ListNode head) {
     *         if (head == null || head.next == null) { return null; }
     *         ListNode slow = head;
     *         ListNode fast = head;
     *         while (fast != null && fast.next != null) {
     *             slow = slow.next;
     *             fast = fast.next.next;
     *             if (slow == fast) {
     *                 break;
     *             }
     *         }
     *         if (fast == null || fast.next == null) {
     *             return null;
     *         }
     *         slow = head;
     *         while (slow != fast) {
     *             slow = slow.next;
     *             fast = fast.next;
     *         }
     *         return slow;
     *     }
     * @return
     *
     *
     *
     * 快慢node,当两个node相遇，慢node回到head，都一步一步走，再次相遇就是环第一个起点
    */
    public static ListNode detectCycleA(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null&&quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (slow.equals(quick)){
                break;
            }
        }
        if (quick == null || quick.next == null) {
            return null;
        }

        slow = head;
        while(!slow.equals(quick)){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
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

        ListNode p = detectCycleA(n1);
        System.out.println(p == null?"null":p.val);
    }
}
