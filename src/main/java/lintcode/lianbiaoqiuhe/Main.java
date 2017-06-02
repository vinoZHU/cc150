package lintcode.lianbiaoqiuhe;

import java.math.BigInteger;

/**
 * Created by vino on 2017/6/1.
 */
public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode tmp = l1;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        tmp = l2;
        tmp.next = new ListNode(9);
        tmp = tmp.next;
        tmp.next = new ListNode(5);
        new Main().addLists2(l1, l2);

    }
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        String num1 = "";
        String num2 = "";
        while (l1 != null) {
            num1 += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 += l2.val;
            l2 = l2.next;
        }

        BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));
        String sumStr = String.valueOf(sum);
        ListNode result = null;
        ListNode tmp = null;
        while (sumStr.length() > 0) {
            int num = Integer.valueOf(sumStr.substring(0, 1));
            if (result == null) {
                result = new ListNode(num);
                tmp = result;
            }
            else {
                ListNode nextNode = new ListNode(num);
               tmp.next = nextNode;
               tmp = nextNode;
            }
            sumStr = sumStr.substring(1, sumStr.length());
        }
        return result;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
