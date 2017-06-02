package cc150.daoshudikgejiedian;

/**
 * Created by vino on 2017/6/1.
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class Main {

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

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
