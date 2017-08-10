package jianzhioffer;

import java.util.HashMap;

/**
 * Created by vino on 2017/8/9.
 *
 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;
        ListNode pointer = pHead;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(pointer.val, 1);
        while (pointer.next != null) {
            if (map.containsKey(pointer.next.val)) {
                map.put(pointer.next.val, map.get(pointer.next.val) + 1);
            }
            else {
                map.put(pointer.next.val, 1);
            }
            pointer = pointer.next;
        }
        pointer = pHead;
        while (map.get(pointer.val) > 1) {
            pHead = pHead.next;
            pointer = pHead;
            if (pHead == null)
                return null;
        }
        while (pointer.next != null) {
            if (map.get(pointer.next.val) > 1) {
                pointer.next = pointer.next.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        return pHead;
    }
}