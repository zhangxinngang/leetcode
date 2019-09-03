package com.leetcode.zh3ng.solutions;

import model.ListNode;

public class SplitLinkedListinParts725 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int length = getLength(root);

        ListNode[] result = new ListNode[k];
        int sublen = length/k;   //一行有几个
        int mod = length % k;    //取模的行数
        ListNode p = root;
        for (int i = 0;i < k;i++){
            if (p == null){
                continue;
            }
            result[i] = p;
            for (int l = 1;l<sublen;l++){
                p = p.next;
            }
            if (i < mod && sublen > 0){
                p = p.next;
            }
            ListNode q = p.next;
            p.next = null;
            p = q;
        }
        return result;
    }

    public static int getLength(ListNode root){
        int count = 0;
        while(root != null){
            count += 1;
            root = root.next;
        }
        return count;
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


        ListNode[] result = splitListToParts(n1,7);

        for (ListNode r:result){
            System.out.println("llllllll");
            while (r != null){
                System.out.println(r.val);
                r = r.next;
            }
            System.out.println("llllllll");
        }

    }

}
