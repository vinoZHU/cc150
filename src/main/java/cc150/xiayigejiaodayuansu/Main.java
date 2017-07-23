package cc150.xiayigejiaodayuansu;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by vino on 2017/7/23.
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。保证数组中元素均为正整数。
 测试样例：
 [11,13,10,5,12,21,3],7
 返回：[13,21,12,12,21,-1,-1]
 */
public class Main {
    public static void main(String[] args) {
        int[] data = {11,13,10,5,12,21,3};
        System.out.println(Arrays.toString(new Main().findNext(data, 7)));
    }


    public int[] findNext(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() == -1) {
                    result[i] = -1;
                    stack.push(A[i]);
                    break;
                }
                else {
                    if (stack.peek() > A[i]) {
                        result[i] = stack.peek();
                        stack.push(A[i]);
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
        }
        return result;
    }
}
