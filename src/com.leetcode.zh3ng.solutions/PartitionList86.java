package com.leetcode.zh3ng.solutions;

import model.ListNode;

/*
 * created by zhangxingang on 2019/08/08
 */
public class PartitionList86 {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Example:
     *
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     */


    public static ListNode partition(ListNode head, int x) {
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = new ListNode(0);
        greaterHead.next = greaterTail;

        ListNode lessHead = new ListNode(0);
        ListNode lessTail = new ListNode(0);
        lessHead.next = lessTail;

        while (head != null){
            if (head.val >= x) {
                greaterTail.next = new ListNode(head.val);
                greaterTail = greaterTail.next;
            }else{
                lessTail.next = new ListNode(head.val);
                lessTail = lessTail.next;
            }
            head = head.next;
        }

        lessTail.next = greaterHead.next.next;
        return lessHead.next.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(2);
        n5.next = n6;

        ListNode n = partition(n1,3);
        System.out.println("      ");
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }

}
