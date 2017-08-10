package jianzhioffer;


/**
 * Created by vino on 2017/8/9.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode parent = pNode.next;
        if (parent == null || pNode.right != null) {
            TreeLinkNode node = pNode.right;
            if (node == null)
                return null;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        if (parent.right == pNode) {
            TreeLinkNode pparent = parent.next;
            if (pparent == null || pparent.right == parent)
                return null;
            return parent.next;
        }
        if (parent.left == pNode)
            return parent;

        return null;
    }
}