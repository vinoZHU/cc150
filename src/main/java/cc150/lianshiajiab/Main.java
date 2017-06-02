package cc150.lianshiajiab;

import java.math.BigInteger;

/**
 * Created by vino on 2017/6/2.
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 测试样例：
 {1,2,3},{3,2,1}
 返回：{4,4,4}
 */
public class Main {

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        a.next = new ListNode(1);
        ListNode b = new ListNode(4);
        b.next = new ListNode(3);
        new Main().plusAB(a, b);
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        String num1 = "";
        String num2 = "";
        while (a != null) {
            num1 = a.val + num1;
            a = a.next;
        }
        while (b != null) {
            num2 = b.val + num2;
            b = b.next;
        }
        BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));
        String sumStr = sum.toString();
        int length = sumStr.length();
        ListNode head = null;
        ListNode next = null;
        while (length > 0) {
            if (head == null) {
                head = new ListNode(Integer.valueOf(sumStr.substring(length - 1, length)));
                next = head;
            }
            else {
                ListNode newNode = new ListNode(Integer.valueOf(sumStr.substring(length - 1, length)));
                next.next = newNode;
                next = newNode;
            }
            length--;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}