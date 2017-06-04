package cc150.xunzhaoxiayigejiedian;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by vino on 2017/6/4.
 *
 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
public class Main {
    public int findSucc(TreeNode root, int p) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
        TreeNode currentNode = null;
        boolean find = false;
        stack.push(root);
        visitedMap.put(root, true);
        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            if (currentNode.left != null && !visitedMap.containsKey(currentNode.left)) {
                currentNode = currentNode.left;
                stack.push(currentNode);
                continue;
            }
            if (find && !visitedMap.containsKey(currentNode))
                return currentNode.val;
            if (currentNode.val == p)
                find = true;
            visitedMap.put(currentNode, true);
            if (currentNode.right != null && !visitedMap.containsKey(currentNode.right)) {
                currentNode = currentNode.right;
                stack.push(currentNode);
                continue;
            }
            stack.pop();

        }
        return -1;
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