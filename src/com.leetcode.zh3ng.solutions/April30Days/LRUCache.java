package com.leetcode.zh3ng.solutions.April30Days;

import java.util.*;

/**
 * created by zhangxingang on 2020/04/24
 *
 *Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 *
 *
 * 解题思路：
 * 1.用双向联调存储 LRU 寿命，链表头永远是最久未使用的
 * 2.用map 存k v，node为双线链表节点，每次get or put操作，都将该node从链表原位置移动到联调尾
 *
 */

public class LRUCache {
    private int capacity;
    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            if (node.next != null){
                //先删node
                node.prev.next = node.next;
                node.next.prev = node.prev;

                //再尾部追加node
                node.prev = tail.prev;
                tail.prev.next = node;
                node.next = tail;
                tail.prev = node;
            }
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            //先删node
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //再尾部追加node
            node.prev = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
        }else{
            Node node = new Node();
            node.value = value;
            node.key = key;
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            map.put(key,node);
        }
        if (map.size() > capacity){
            Node n = head.next;
            if (n != null){
                map.remove(n.key);
                n.next.prev = head;
                head.next = n.next;
            }
        }
    }

    private class Node{
        public int key;
        public int value;
        public Node next;
        public Node prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}
