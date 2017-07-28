package niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by vino on 2017/7/28.
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 测试样例：
 1
 返回：["0","1"]
 */
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GrayCode().getGray(2)));
    }

    public String[] getGray(int n) {
        String zero = "0";
        String one = "1";
        // write code here
        if (n == 1)
            return new String[]{zero, one};
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(zero);
        queue.offer(one);
        boolean isZeroFirst = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                String tmp = queue.poll();
                if (isZeroFirst) {
                    queue.offer(tmp + zero);
                    queue.offer(tmp + one);
                    isZeroFirst = false;
                }
                else {
                    queue.offer(tmp + one);
                    queue.offer(tmp + zero);
                    isZeroFirst = true;
                }

            }
        }
        String[] result = new String[queue.size()];
        int length = queue.size();
        for (int i = 0; i < length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
