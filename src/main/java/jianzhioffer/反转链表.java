package jianzhioffer;

import java.util.Stack;

/**
 * Created by vino on 2017/8/11.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new 反转链表().ReverseList(head);
    }
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode pointer = head;
        while (!stack.isEmpty()) {
            pointer.next = stack.pop();
            pointer = pointer.next;
        }
        pointer.next = null;

        return head;
    }
}
