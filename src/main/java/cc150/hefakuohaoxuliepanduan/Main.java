package cc150.hefakuohaoxuliepanduan;

import java.util.Stack;

/**
 * Created by vino on 2017/6/17.
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 测试样例：
 "(()())",6
 返回：true
 测试样例：
 "()a()()",7
 返回：false
 测试样例：
 "()(()()",7
 返回：false
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().chkParenthesis("()a()()", 7));
    }

    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (A.charAt(i) == '(')
                stack.push('(');
            else if (A.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            else {
                if (stack.isEmpty())
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
