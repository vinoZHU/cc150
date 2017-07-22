package cc150.shuzhuanlianbiao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by vino on 2017/7/22.
 */
public class Main {

    public ListNode treeToList(TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visitedSet = new HashSet<>();
        stack.push(root);

        ListNode head = null;
        ListNode pointer = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !visitedSet.contains(node.left)) {
                stack.push(node.left);
                continue;
            }
            if (head == null) {
                head = new ListNode(node.val);
                pointer = head;
                visitedSet.add(stack.pop());
            }
            else {
                pointer.next = new ListNode(node.val);
                pointer = pointer.next;
                visitedSet.add(stack.pop());
            }
            if (node.right != null && !visitedSet.contains(node.right)) {
                stack.push(node.right);
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
