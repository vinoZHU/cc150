package jianzhioffer;

import java.util.*;

/**
 * Created by vino on 2017/8/11.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(new 栈的压入弹出序列().IsPopOrder(pushA, popA));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int indexIn = 1;
        for (int i = 0; i < popA.length; i++) {
            boolean flag = false;
            if (!stack.isEmpty()) {
                if (stack.peek() == popA[i]) {
                    stack.pop();
                    flag = true;
                }
            }
            while (indexIn < pushA.length) {
                if (pushA[indexIn] == popA[i]) {
                    indexIn++;
                    flag = true;
                    break;
                }
                else {
                    stack.push(pushA[indexIn++]);
                }
            }
            if (!flag)
                return false;

        }
        return true;

    }
}
