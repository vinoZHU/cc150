package jianzhioffer;

import java.util.Stack;

/**
 * Created by vino on 2017/8/10.
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int ret = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return ret;
    }
}
