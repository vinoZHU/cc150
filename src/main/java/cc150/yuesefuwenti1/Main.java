package cc150.yuesefuwenti1;

import java.util.LinkedList;

/**
 * Created by vino on 2017/6/28.
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 测试样例：
 5 3
 返回：4
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().getResult(5, 3));
    }

    public int getResult(int n, int m) {
        // write code here
        if (n == 1) return 1;

        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            current.next = node;
            node.before = current;
            current = node;
        }
        head.before = current;
        current.next = head;
        Node pointer = head;
        while (n > 0) {
            for (int i = 1; i < m; i++) {
                pointer = pointer.next;
            }
            Node tmp = pointer.next;
            pointer.before.next = pointer.next;
            pointer.next.before = pointer.before;
            pointer = tmp;
            n--;
        }
        return pointer.num;
    }

    class Node {
        int num;
        Node next;
        Node before;

        public Node(int num) {
            this.num = num;
        }
    }
}
