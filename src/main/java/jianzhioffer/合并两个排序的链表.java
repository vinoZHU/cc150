package jianzhioffer;

/**
 * Created by vino on 2017/8/11.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        ListNode listNode = new 合并两个排序的链表().Merge(head, head1);
        System.out.println("===");
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list2 == null)
            return list1;
        if (list1 == null)
            return list2;
        ListNode head = null;
        ListNode pointer = null;
        while (!(list1 == null && list2 == null)) {

            if (list1 == null) {
                pointer.next = list2;
                return head;
            }
            else if (list2 == null) {
                pointer.next = list1;
                return head;
            }
            if (list1.val <= list2.val) {
                if (head == null) {
                    head = list1;
                    pointer = head;
                }
                else {
                    pointer.next = list1;
                    pointer = pointer.next;
                }
                list1 = list1.next;
            }
            else {
                if (head == null) {
                    head = list2;
                    pointer = head;
                }
                else {
                    pointer.next = list2;
                    pointer = pointer.next;
                }
                list2 = list2.next;
            }
        }
        return head;
    }
}
