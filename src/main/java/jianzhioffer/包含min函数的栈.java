package jianzhioffer;

import java.util.Stack;

/**
 * Created by vino on 2017/8/11.
 */
public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min.isEmpty()) {
            min.push(node);
        }
        else if (node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        if (stack.peek() == min.peek()) {
            stack.pop();
            min.pop();
        }
        else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (min.isEmpty())
            return -1;
        return min.peek();
    }
}
