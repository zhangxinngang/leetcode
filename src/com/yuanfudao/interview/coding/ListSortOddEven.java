package com.yuanfudao.interview.coding;

import javafx.util.Pair;
import model.ListNode;


/**
 * @author zhangxingang
 * @created on 2020/10/9
 *
 * 给个链表 1->3->4->2:
 *
 * 分成两个链表 奇数一个偶数一个，并排序
 *
 * 1->3
 * 2->4
 *
 * 要求 空间复杂度 小于O(n)。
 *
 * 只能用
 * Node{
 *  final int val;
 *  Node next;
 * }
 */
public class ListSortOddEven {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(2);

        Pair pair = sort(n1);

        System.out.println(pair);
    }

    public static Pair<ListNode, ListNode> sort(ListNode head){
        head = bubbleSort(head);

        ListNode odd = new ListNode(0);
        ListNode oddH = odd;
        ListNode h = new ListNode(0);
        h.next = head;
        while (h.next != null){
            if (h.next.val % 2 == 1){
                oddH.next = new ListNode(h.next.val);
                ListNode n = h.next;
                h.next= n.next;
                oddH = oddH.next;
            }else{
                h = h.next;
            }
        }
        return new Pair<>(odd.next, h);
    }

    public static ListNode bubbleSort(ListNode head){
        if(head == null || head.next == null)  //链表为空或者仅有单个结点
            return head;

        ListNode cur = null, tail = null;

        cur = head;

        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.val > cur.next.val){
                     int tmp = cur.val;
                     cur.val = cur.next.val;
                     cur.next.val = tmp;
                }
                cur = cur.next;
            }
            tail = cur;     //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }
        return head;
    }


}
