package jianzhioffer;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by vino on 2017/8/11.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {
    LinkedList<TreeNode> linkedList = new LinkedList<>();
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
        TreeNode node = new 二叉搜索树与双向链表().Convert(root);
        System.out.println();
    }
    //非递归
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRootOfTree);
        HashSet<TreeNode> set = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !set.contains(node.left)) {
                stack.push(node.left);
            }
            else {
                linkedList.add(node);
                stack.pop();
                set.add(node);
                if (node.right != null && !set.contains(node.right)) {
                    stack.push(node.right);
                }
            }
        }
        Iterator<TreeNode> iterator = linkedList.iterator();
        TreeNode head = iterator.next();
        TreeNode p = head;
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            p.right = node;
            node.left = p;
            p = node;
        }

        return head;
    }

    /*
    递归

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;
        inOrder(pRootOfTree);
        Iterator<TreeNode> iterator = linkedList.iterator();
        TreeNode head = iterator.next();
        TreeNode p = head;
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            p.right = node;
            node.left = p;
            p = node;
        }
        return head;

    }
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        linkedList.add(node);
        inOrder(node.right);
    }
    */

}
