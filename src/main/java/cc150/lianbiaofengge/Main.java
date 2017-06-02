package cc150.lianbiaofengge;

/**
 * Created by vino on 2017/6/1.
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);//434
        ListNode head1 = new ListNode(1);//435
        ListNode head2 = new ListNode(0);//436
        ListNode head3 = new ListNode(5);//437
        ListNode head4 = new ListNode(1);//438
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        new Main().partition(head, 2);
    }
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode i = null;
        ListNode j = pHead;
        ListNode head = null;
        ListNode before = null;
        while (j != null) {
            if (j.val < x) {
                if (head == null) {
                    head = j;
                    i = j;
                    if (j != pHead) {
                        before.next = j.next;
                        j.next = pHead;
                        j = before.next;
                    }
                    else {
                        before = j;
                        j = j.next;
                    }

                }
                else {
                    if (before == i) {
                        i = i.next;
                        before = j;
                        j = j.next;
                    }
                    else {
                        ListNode tmp = i.next;
                        i.next = j;
                        before.next = j.next;
                        j.next = tmp;
                        i = i.next;
                        j = before;
                        before = j;
                        j = j.next;
                    }
                }
            }
            else {
                before = j;
                j = j.next;
            }

        }
        return head == null ? pHead : head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
