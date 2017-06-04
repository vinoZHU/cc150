package cc150.jianchashifouweiBST;

/**
 * Created by vino on 2017/6/4.
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(1);
        root.left = root2;
        root2.left = root3;
        root3.left = root4;
        root4.left = root5;
        root5.left = root6;
        System.out.println(new Main().checkBST(root));

    }

    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null || (root.left ==null && root.right == null))
            return true;
        if (root.left == null) {
            if (root.right.val > root.val) {
                if (root.right.left != null && root.right.left.val < root.val) {
                    return false;
                }
                return checkBST(root.right);
            }

            return false;
        }
        if (root.right == null) {
            if (root.left.val < root.val) {
                if (root.left.right != null && root.left.right.val > root.val) {
                    return false;
                }
                return checkBST(root.left);
            }
            return false;
        }
        if (root.right.val > root.val && root.left.val < root.val) {
            if (root.right.left != null && root.right.left.val < root.val) {
                return false;
            }
            if (root.left.right != null && root.left.right.val > root.val) {
                return false;
            }
            return checkBST(root.left) || checkBST(root.right);
        }
        return false;
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