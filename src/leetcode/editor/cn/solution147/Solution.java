package leetcode.editor.cn.solution147;

//Sort a linked list using insertion sort. 
//
// 
// 
//
// 
//A graphical example of insertion sort. The partial sorted list (black) initial
//ly contains only the first element in the list. 
//With each iteration one element (red) is removed from the input data and inser
//ted in-place into the sorted list 
// 
//
// 
// 
//
// Algorithm of Insertion Sort: 
//
// 
// Insertion sort iterates, consuming one input element each repetition, and gro
//wing a sorted output list. 
// At each iteration, insertion sort removes one element from the input data, fi
//nds the location it belongs within the sorted list, and inserts it there. 
// It repeats until no input elements remain. 
// 
//
// 
//Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 355 👎 0


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
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode();
        if (head == null || head.next == null){
            return head;
        }
        ListNode tmp = head;
        head = head.next;
        tmp.next = null;
        result.next = tmp;
        while (head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            insert(temp, result);
        }
        return result.next;
    }

    public void insert(ListNode node, ListNode result){
        if (node.val <= result.next.val){
            node.next = result.next;
            result.next = node;
            return;
        }
        ListNode temp = result;
        while (temp.next != null){
            if (node.val <= temp.next.val){
                node.next = temp.next;
                temp.next = node;
                return;
            }else{
                temp = temp.next;
            }
        }
        temp.next = node;
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

        ListNode n6 = new ListNode(-1);
        n5.next = n6;

        Solution solution = new Solution();


        head = solution.insertionSortList(head);

        System.out.println(head.val);
        while (head.next != null){
            System.out.println(head.next.val);
            head = head.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
