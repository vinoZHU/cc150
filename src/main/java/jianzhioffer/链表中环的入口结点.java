package jianzhioffer;

/**
 * Created by vino on 2017/8/9.
 *  由上题可知，按照 p2 每次两步，p1 每次一步的方式走，发现 p2 和 p1 重合，确定了单向链表有环路了。接下来，让p2回到链表的头部，重新走，每次步长不是走2了，而是走1，那么当 p1 和 p2 再次相遇的时候，就是环路的入口了。

 为什么？：假定起点到环入口点的距离为 a，p1 和 p2 的相交点M与环入口点的距离为b，环路的周长为L，当 p1 和 p2 第一次相遇的时候，假定 p1 走了 n 步。那么有：
 * p1走的路径： a+b ＝ n；
 p2走的路径： a+b+k*L = 2*n； p2 比 p1 多走了k圈环路，总路程是p1的2倍

 根据上述公式可以得到 k*L=a+b=n显然，如果从相遇点M开始，p1 再走 n 步的话，还可以再回到相遇点，同时p2从头开始走的话，经过n步，也会达到相遇点M。
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
            return null;
        if (pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode pointer1 = pHead.next;
        ListNode pointer2 = pHead.next.next;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            if (pointer1 == null)
                return null;
            pointer2 = pointer2.next.next;
            if (pointer2 == null)
                return null;
        }
        pointer2 = pHead;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if (pointer1 == null || pointer2 == null)
                return null;
        }
        return pointer1;
    }
}
