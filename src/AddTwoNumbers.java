import model.ListNode;

/*
 * created by zhangxingang on 2019/05/10
 * leetcode 2
 */
public class AddTwoNumbers {
    public static void addToTail(ListNode head, ListNode node){
        if (head == null){
            return;
        }
        ListNode next = head.next;
        if (next == null){
            head.next = node;
        }
        while (next != null){
            if (next.next == null){
                next.next = node;
                break;
            }else{
                next = next.next;
            }
        }
    }

    private static void ergodic(ListNode head){
        ListNode node = head;
        while (null != node.next) {
            System.out.print(node.val);
            node = node.next;
        }
        if (node.next == null){
            System.out.println(node.val);
        }
    }

    private static ListNode reverse(ListNode head){
        ListNode head1 = new ListNode(0);
        head1.next = head;
        if (head1 == null || head1.next == null || head1.next.next == null){
            return head;
        }
        ListNode p = head1.next.next;
        head1.next.next = null;
        while(p != null){
            ListNode q = p.next;
            p.next = head1.next;
            head1.next = p;
            p = q;
        }
        return head1.next;
    }

    private static ListNode addTwo(ListNode head1, ListNode head2){
        ListNode node1 = head1;
        ListNode node2 = head2;

        int n = 0;
        while(node1 != null){
            int v1 = node1.val;
            int v2 = node2 == null ? 0 : node2.val;
            node1.val = (v1 + v2 + n)%10;
            if ((v1 + v2 + n)>=10){
                n = 1;
            }else {
                n = 0;
            }
            node1 = node1.next;
            node2 = node2 == null ? null:node2.next;
        }
        if (node1 == null && n == 1){
            ListNode node = new ListNode(1);
            addToTail(head1,node);
        }
        return head1;
    }

    public static int length(ListNode h){
        ListNode n = h.next;
        int i = 1;
        while (n != null){
            n = n.next;
            i++;
        }
        return i;
    }

    public static ListNode addTwoNumbers(ListNode head1,ListNode head2){
        int l1 = length(head1);
        int l2 = length(head2);
        if (l1 > l2){
            return addTwo(head1,head2);
        }else{
            return addTwo(head2,head1);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
//        addToTail(head,new ListNode(4));
//        addToTail(head,new ListNode(3));

        ListNode head2 = new ListNode(7);
        addToTail(head2,new ListNode(3));
        //addToTail(head2,new ListNode(4));

        ListNode h1 = reverse(head);
        ListNode h2 = reverse(head2);
//
        ListNode result = addTwoNumbers(h1,h2);

        //ListNode reverseLink = reverse(result);

        ergodic(result);
        //LinkList.ergodic(head);
    }
}
