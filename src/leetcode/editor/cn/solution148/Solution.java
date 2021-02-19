package leetcode.editor.cn.solution148;

//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 999 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 *
 * 主要用归并排序
 * 1.先找到链表中点 「快慢指针」  O(n)
 * 2.根据中点分开左右两个链表，递归分别给两个链表排序，并合并链表 O(nlog(n))
 *
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        ListNode pre = sortList(left);
        ListNode pos = sortList(right);

        return merge(pre, pos);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode h = null;
        ListNode temp = new ListNode();
        h = temp;
        while (left != null || right != null){
            if (left != null && right != null){
                if (left.val <= right.val){
                    temp.next = left;
                    temp = temp.next;
                    left = left.next;
                }else{
                    temp.next = right;
                    temp = temp.next;
                    right = right.next;
                }
            }else if(left == null){
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }else if(right == null){
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
        }
        return h.next;
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode n1 = new ListNode(1);
        head.next = n1;

        ListNode n2 = new ListNode(4);
        n1.next = n2;

        ListNode n3 = new ListNode(3);
        n2.next = n3;

        ListNode n4 = new ListNode(2);
        n3.next = n4;

        ListNode n5 = new ListNode(5);
        n4.next = n5;

        Solution solution = new Solution();


        head = solution.sortList(head);

        System.out.println(head.val);
        while (head.next != null){
            System.out.println(head.next.val);
            head = head.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
