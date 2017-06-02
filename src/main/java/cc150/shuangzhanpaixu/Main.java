package cc150.shuangzhanpaixu;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by vino on 2017/6/2.
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 测试样例：
 [1,2,3,4,5]
 返回：[5,4,3,2,1]
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 4, 8};
        System.out.println(new Main().twoStacksSort(numbers));
    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = numbers.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            stack.push(numbers[i]);
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] > stack.peek()) {
                    int tmp = numbers[j];
                    numbers[j] = stack.pop();
                    stack.push(tmp);
                }
            }
            result.add(stack.pop());
        }
        return result;
    }
}
