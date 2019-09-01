/*
 * created by zhangxingang on 2019/08/08
 */
//todo
public class MyLinkedList707 {
    private LinkNode head;
    private LinkNode tail;

    public class LinkNode {
        public LinkNode next;

        public int val;

        public LinkNode(int a) {
            val = a;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList707() {
        head.next = tail;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkNode h = new LinkNode(val);
        h.next = head;
        head = h;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkNode t = new LinkNode(val);
        tail.next = t;
        tail = tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
        }
        LinkNode p = head;
        for (int i = 0;i<index;i++){
            p = p.next;
            if (p == null){
                return;
            }
        }
        LinkNode q = new LinkNode(val);
        q.next = p.next;
        p.next = q;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }
}
