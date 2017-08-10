package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode e1 = new TreeNode(2);
        TreeNode e2 = new TreeNode(3);
        TreeNode e3 = new TreeNode(4);
        TreeNode e4 = new TreeNode(5);
        root.right = e1;
        e1.right = e2;
        e2.right = e3;
        e3.right = e4;
        System.out.println(new 二叉树的深度().TreeDepth(root));
    }
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
