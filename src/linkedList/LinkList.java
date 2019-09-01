package linkedList;

/*
 * created by zhangxingang on 2019/04/18
 */
public class LinkList {


    /**
     * @method 在链表头加node
     * @date 2019-04-18 19:02
     * @author zhangxingang
     * @description  
     * @param null
     * @return  
    */
    public static void addToHead(LinkNode head,LinkNode node){
        if (head == null){
            return;
        }
        node.next = head.next;
        head.next = node;
    }


    /**
     * @method 在链表尾加node
     * @date 2019-04-18 19:00
     * @author zhangxingang
     * @description  
     * @param null
     * @return  
    */
    public static void addToTail(LinkNode head, LinkNode node){
        if (head == null){
            return;
        }
        LinkNode next = head.next;
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

    /**
     * @method 遍历链表
     * @date 2019-04-18 19:00
     * @author zhangxingang
     * @description  
     * @param null
     * @return  
    */
    public static void ergodic(LinkNode head){
        if (head == null && head.next == null){
            return;
        }
        LinkNode node = head.next;
        while (null != node.next) {
            System.out.print(node.val);
            node = node.next;
        }
        if (node.next == null){
            System.out.println(node.val);
        }
    }

    /**
     * @method 反转链表
     * @date 2019-04-18 19:00
     * @author zhangxingang
     * @description  
     * @param null
     * @return  
    */
    public static void reverseA(LinkNode head){
        if (head == null || head.next == null || head.next.next == null){
            //检查linknode的合法性
            return;
        }
        LinkNode p = head.next.next;
        head.next.next = null;
        while(p != null){
            LinkNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
    }

    public static void reverse(LinkNode head){
        if (head == null || head.next == null|| head.next.next == null){
            return ;
        }
        LinkNode p = head.next.next;
        head.next.next = null;
        while(p != null){
            LinkNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
    }

    /**
     * @method clone node 放在新list上
     * @date 2019-04-19 11:56
     * @author zhangxingang
     * @description  
     * @param null
     * @return  
    */
    public static void reverse(LinkNode head,LinkNode resultHead){
        if (head == null || resultHead == null){
            return;
        }
        LinkNode node = head.next;
        while(node != null){
            LinkNode newNode = new LinkNode(node.val);
            if (resultHead.next==null){
                resultHead.next = newNode;
            }else{
                newNode.next = resultHead.next;
                resultHead.next = newNode;
            }
            node = node.next;
        }
    }
}
