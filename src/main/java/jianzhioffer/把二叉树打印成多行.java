package jianzhioffer;

import java.util.*;

/**
 * Created by vino on 2017/8/9.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        int k = 0;//level
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = doPrintLevel(queue);
            lists.add(list);
            k++;
        }
        return lists;
    }

    private ArrayList<Integer> doPrintLevel(Queue<TreeNode> queue) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer count = queue.size();
        for (int i = 0; i < count && !queue.isEmpty(); i++) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}

