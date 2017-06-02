package cc150.lianggezhanshixianduilie;

import java.util.Stack;

/**
 * Created by vino on 2017/6/2.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Main {
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
