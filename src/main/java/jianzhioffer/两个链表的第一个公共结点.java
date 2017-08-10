package jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by vino on 2017/8/10.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set1 = new HashSet<>();
        HashSet<ListNode> set2 = new HashSet<>();
        while (!(pHead1 == null && pHead2 == null)) {
            if (pHead1 == null) {
                if (set1.contains(pHead2))
                    return pHead2;
                pHead2 = pHead2.next;
                continue;
            }
            if (pHead2 == null) {
                if (set2.contains(pHead1))
                    return pHead1;
                pHead1 = pHead1.next;
                continue;
            }
            if (set2.contains(pHead1))
                return pHead1;
            set1.add(pHead1);
            if (set1.contains(pHead2))
                return pHead2;
            set2.add(pHead2);
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
