package niuke;

import java.util.*;

/**
 * Created by vino on 2017/7/27.
 *
 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 测试样例：
 1
 返回：["down"]
 */
public class FoldPaper {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FoldPaper().foldPaper(5)));

    }
    public String[] foldPaper(int n) {
        // write code here
        String down = "down";
        String up = "up";
        Queue<Node> queue = new ArrayDeque<>();
        Node root = new Node(down);
        queue.offer(root);
        int level = 1;
        while (n > 1) {
            for (int i = 0; i < Math.pow(2, level - 1); i++) {
                Node node = queue.poll();
                node.left = new Node(down);
                node.right = new Node(up);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            level++;
            n--;
        }

        ArrayList<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        HashSet<Node> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                continue;
            }
            else if (!visited.contains(node)){
                stack.pop();
                list.add(node.direction);
                visited.add(node);
            }
            if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
            }

        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;

    }

    class Node {
        Node left;
        Node right;
        String direction;

        public Node(String direction) {
            this.direction = direction;
        }
    }

}
