题意是让我们用插入排序，排序方法那么多为什么要用插入，我排好序不就可以了吗，等等，好像有内置的排序方法，毕竟那些代码都是jdk级的，肯定比我写得好，嗯，那么，就这样吧
代码如下：
```java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> n = new ArrayList<>();
        ListNode t = head;
        while(t != null){
            n.add(t.val);
            t = t.next;
        }
        Collections.sort(n);
        t = head;
        for(int i = 0; i < n.size(); i++){
            t.val = n.get(i);
            t = t.next;
        }
        return head;
    }
}
```
