package jianzhioffer;

import java.util.Stack;

/**
 * Created by vino on 2017/8/11.
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        /*
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
        */
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}
