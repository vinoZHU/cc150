package cc150.shuchudancengjiedian;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by vino on 2017/6/4.
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
 请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class Main {

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        ListNode head = null;
        ListNode next = null;
        if (dep == 1 && root != null) {
            head = new ListNode(root.val);
        }
        else {
            HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
            int currentDep = 1;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode currentNode = root;
            while (dep >= currentDep) {
                if (dep == currentDep) {
                    if (head == null) {
                        head = new ListNode(currentNode.val);
                        next = head;
                    }
                    else {
                        next.next = new ListNode(currentNode.val);
                        next = next.next;
                    }
                    if (!stack.isEmpty()) {
                        currentNode = stack.pop();
                        currentDep--;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                if (currentNode != null) {
                    if (currentNode.left != null && !visitedMap.containsKey(currentNode.left)) {
                        stack.push(currentNode);
                        currentNode = currentNode.left;
                        currentDep++;
                        visitedMap.put(currentNode, true);
                    } else if (currentNode.right != null && !visitedMap.containsKey(currentNode.right)) {
                        stack.push(currentNode);
                        currentNode = currentNode.right;
                        currentDep++;
                        visitedMap.put(currentNode, true);
                    }
                    else {
                        if (!stack.isEmpty()) {
                            currentNode = stack.pop();
                            currentDep--;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
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
