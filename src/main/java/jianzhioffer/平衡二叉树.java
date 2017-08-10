package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        else {
            return false;
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;

    }
}
