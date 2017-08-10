package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by vino on 2017/8/9.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean direction = true;//正向
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = doPrintLevel(queue, direction);
            lists.add(list);
            direction = !direction;
        }
        return lists;
    }
    private ArrayList<Integer> doPrintLevel(Queue<TreeNode> queue, boolean direction) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer count = queue.size();
        Stack<TreeNode> stack = new Stack<>();
        if (!direction) {
            for (int i = 0; i < count && !queue.isEmpty(); i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
        }
        else {
            for (int i = 0; i < count && !queue.isEmpty(); i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
        }

        return list;
    }
}
