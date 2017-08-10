package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by vino on 2017/8/10.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }
}
