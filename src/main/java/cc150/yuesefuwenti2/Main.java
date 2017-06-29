package cc150.yuesefuwenti2;


/**
 * Created by vino on 2017/6/28.
 * 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
 * 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
 * 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 测试样例：
 5
 返回：5
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().getResult(5));
    }

    public int getResult(int n) {
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
        current.last = true;
        Node pointer = head;
        int maxNum = 2;
        while (n > 1) {
            int limit = n;
            while (limit > 0) {
                for (int num = 1; num <= maxNum && limit > 0; num++) {
                    limit--;
                    if (num != 1 && pointer.next != null) {
                        //delete
                        Node tmp = pointer.next;
                        pointer.before.next = pointer.next;
                        pointer.next.before = pointer.before;
                        pointer.next = null;
                        pointer.before = null;
                        if (limit > 0) {
                            pointer = tmp;
                        }
                        else {
                            pointer = tmp.before;
                        }

                        n--;
                    }
                    else {
                        if (limit > 0)
                            pointer = pointer.next;
                    }
                }
            }
            maxNum++;

        }
        return pointer.num;
    }

    class Node {
        int num;
        Node next;
        Node before;
        boolean last;

        public Node(int num) {
            this.num = num;
        }
    }
}
