package jianzhioffer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by vino on 2017/8/8.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class 二叉搜索树的第k个结点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode e1 = new TreeNode(6);
        TreeNode e2 = new TreeNode(10);
        TreeNode e3 = new TreeNode(5);
        TreeNode e4 = new TreeNode(7);
        TreeNode e5 = new TreeNode(9);
        TreeNode e6 = new TreeNode(11);

        root.left = e1;
        root.right = e2;
        e1.left = e3;
        e1.right = e4;
        e2.left = e5;
        e2.right = e6;

        new 二叉搜索树的第k个结点().KthNode(root, 2);
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(pRoot);
        TreeNode node = null;
        TreeNode pointer = null;
        while (k > 0 && !stack.isEmpty()) {
            pointer = stack.peek();
            while (pointer.left != null && !visited.contains(pointer.left)) {
                stack.push(pointer.left);
                pointer = pointer.left;
            }
            node = stack.pop();
            visited.add(node);
            k--;
            if (k == 0)
                return node;
            if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
            }
        }
        return null;
    }
}
