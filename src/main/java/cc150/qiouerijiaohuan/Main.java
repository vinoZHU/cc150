package cc150.qiouerijiaohuan;

import java.util.Stack;

/**
 * Created by vino on 2017/6/6.
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）
 给定一个int x，请返回交换后的数int。
 测试样例：
 10
 返回：5
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().exchangeOddEven(10));
    }

    public int exchangeOddEven(int x) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            int a = x & 1;
            x >>= 1;
            int b = x & 1;
            x >>= 1;
            stack.push(b);
            stack.push(a);

        }
        while (!stack.isEmpty()) {
            x = x << 1 | stack.pop();
        }
        return x;
    }
}
