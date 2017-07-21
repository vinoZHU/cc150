package cc150.zuixiaotiaozhengyouxu;

import java.util.Arrays;

/**
 * Created by vino on 2017/7/21.
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。
 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。
 测试样例：
 [1,4,6,5,9,10],6
 返回：[2,3]
 */
public class Main {

    public static void main(String[] args) {
        int[] data = {1,4,5,6,9,10};
        System.out.println(Arrays.toString(new Main().findSegment(data, 6)));
    }

    public int[] findSegment(int[] A, int n) {
        // write code here
        int[] tmp = new int[n];
        System.arraycopy(A, 0, tmp, 0, n);
        Arrays.sort(A);
        if (Arrays.equals(A, tmp))
            return new int[]{0, 0};
        int i = 0, j = 0;
        for (; i < n; i++) {
            if (A[i] == tmp[i])
                continue;
            else
                break;
        }
        for (j = n - 1; j > 0; j--) {
            if (A[j] == tmp[j])
                continue;
            else
                break;
        }
        return new int[]{i, j};
    }
}
