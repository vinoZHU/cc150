package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by vino on 2017/8/10.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode currentNode = null;
        int currentSum = root.val;
        stack.push(root);
        visitedMap.put(root, true);
        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            if (currentNode.left != null && !visitedMap.containsKey(currentNode.left)) {
                currentNode = currentNode.left;
                stack.push(currentNode);
                visitedMap.put(currentNode, true);
                currentSum += currentNode.val;
                continue;
            }
            if (currentNode.right != null && !visitedMap.containsKey(currentNode.right)) {
                currentNode = currentNode.right;
                stack.push(currentNode);
                currentSum += currentNode.val;
                visitedMap.put(currentNode, true);
                continue;
            }
            if (currentNode.left == null && currentNode.right == null) {
                if (currentSum == target) {
                    Stack<TreeNode> tmp = new Stack<>();
                    while (!stack.isEmpty()) {
                        tmp.push(stack.pop());
                    }
                    ArrayList<Integer> path = new ArrayList<>();
                    while (!tmp.isEmpty()) {
                        path.add(tmp.peek().val);
                        stack.push(tmp.pop());
                    }
                    result.add(path);
                }
            }
            currentSum -= currentNode.val;
            stack.pop();

        }
        return result;
    }
}
