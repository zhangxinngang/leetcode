package leetcode.editor.cn.solution148;

/**
 * @author zhangxingang
 * @created on 2019/01/21
*/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public int length(){
        ListNode n = next;
        int i = 1;
        while(n != null){
            n = n.next;
            i++;
        }
        return i;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
