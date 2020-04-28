package com.leetcode.zh3ng.solutions.April30Days;

import java.util.*;

/**
 * created by zhangxingang on 2020/04/28
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Example 2:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * Example 3:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 *
 *
 *
 *
 * 思路，采用map + 双链表
 * 1 双链表记录 按顺序的 唯一数值。
 * 2.map 用于记录数值及唯一数值在双链表中的引用。
 *
 * 判断：如果新加入的value在map中存在，说明不是唯一值，则要通过map找到在双链表中的引用，如果没有删除则从链表中删除，如果删除了不处理
 *
 * 查询第一个唯一值为双链表的第一个。
 *
 */
public class FirstUnique {
    Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    private class Node{
        public int value;
        public Node next;
        public Node prev;
    }

    public FirstUnique(int[] nums) {
        head.next = tail;
        tail.prev = head;
        tail.value = -1;
        for (Integer n:nums){
            if (!map.containsKey(n)){
                Node node = new Node();
                node.value = n;
                map.put(n,node);
                node.prev = tail.prev;
                tail.prev = node;
                node.prev.next = node;
                node.next = tail;
            }else{
                Node node = map.get(n);
                if (node.value != -1){
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.value = -1;
            }
        }
    }

    public int showFirstUnique() {
        return head.next.value;
    }

    public void add(int value) {
        if (!map.containsKey(value)){
            Node node = new Node();
            node.value = value;
            map.put(value,node);
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
        }else{
            Node node = map.get(value);
            if (node.value != -1){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public static void main(String[] args) {
        FirstUnique f = new FirstUnique(new int[]{2,2,2});

        System.out.println(f.showFirstUnique());

//        f.add(5);
//
//        System.out.println(f.showFirstUnique());
//
//        f.add(2);
//
//        System.out.println(f.showFirstUnique());
//
//        f.add(3);
//
//        System.out.println(f.showFirstUnique());
    }
}
