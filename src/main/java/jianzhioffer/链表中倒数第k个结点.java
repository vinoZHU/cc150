package jianzhioffer;

/**
 * Created by vino on 2017/8/11.
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode first = head;
        ListNode last = head;
        while (k > 0) {
            if (last == null) {
                return null;
            }
            last = last.next;
            k--;
        }
        while (true) {
            if (last == null) {
                return first;
            }
            first = first.next;
            last = last.next;
        }
    }
}
