package com.custom.zh3ng.algorithms;

import com.custom.zh3ng.algorithms.linkedList.LinkNode;

/**
 * @author zhangxingang
 * @created on 2020-09-08
 */
public class LinkNodeReverse {
    public void reverse(LinkNode head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        LinkNode p = head.next.next;
        head.next.next = null;
        while (p != null){
            LinkNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode(-1);

        LinkNode n1 = new LinkNode(1);
        head.next = n1;
        LinkNode n2 = new LinkNode(2);
        n1.next = n2;
        LinkNode n3 = new LinkNode(3);
        n2.next = n3;
        LinkNode n4 = new LinkNode(4);
        n3.next = n4;
        LinkNode n5 = new LinkNode(5);
        n4.next = n5;
        LinkNode n6 = new LinkNode(6);
        n5.next = n6;

        LinkNodeReverse linkNodeReverse = new LinkNodeReverse();
        linkNodeReverse.reverse(head);

        LinkNode p = head.next;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
