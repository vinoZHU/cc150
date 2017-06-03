package cc150.erchashupinghengjiancha;

/**
 * Created by vino on 2017/6/3.
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Main {
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null)
            return true;
        if (Math.abs(childLength(root.left) - childLength(root.right)) <= 1) {
            return isBalance(root.left) && isBalance(root.right);
        }
        return false;
    }

    private int childLength(TreeNode node) {
        if (node == null)
            return 0;
        int llength = childLength(node.left);
        int rlength = childLength(node.right);
        return llength > rlength ? llength + 1 : rlength + 1;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}