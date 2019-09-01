import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> valSet = new HashSet<>();
        while (headA != null){
            valSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (valSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;

        ListNode m1 = new ListNode(6);
        ListNode m2 = new ListNode(5);
        m1.next = m2;
        ListNode m3 = new ListNode(7);
        m2.next = m3;
        m3.next = n3;

        ListNode result = getIntersectionNode(n1,m1);

        System.out.println(result.val);

    }
}
