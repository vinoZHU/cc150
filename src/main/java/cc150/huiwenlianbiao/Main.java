package cc150.huiwenlianbiao;

/**
 * Created by vino on 2017/6/2.
 * 请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 */
public class Main {

    public boolean isPalindrome(ListNode pHead) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        while (pHead != null) {
            stringBuilder.append(pHead.val);
            pHead = pHead.next;
        }
        String str = stringBuilder.toString();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
