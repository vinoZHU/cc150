package cc150.xiayigejiaodayuansu2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by vino on 2017/7/23.
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
 测试样例：
 [11,13,10,5,12,21,3],7
 [12,21,12,12,21,-1,-1]
 */
public class Main {
    public static void main(String[] args) {
        int[] data = {11,13,10,5,12,21,3};
        System.out.println(Arrays.toString(new Main().findNext(data, 7)));
    }

    public int[] findNext(int[] A, int n) {
        // write code here
        TreeSet<Integer> set = new TreeSet<>();
        int[] result = new int[n];
        for (int i = n -1; i >= 0; i--) {
            if (set.isEmpty()) {
                result[i] = -1;
                set.add(A[i]);
            }
            else {
                Iterator iterator = set.iterator();
                boolean exist = false;
                while (iterator.hasNext()) {
                    int next = (int) iterator.next();
                    if (next > A[i]) {
                        exist = true;
                        result[i] = next;
                        set.add(A[i]);
                    }
                    if (exist)
                        break;
                }
                if (!exist) {
                    result[i] = -1;
                    set.add(A[i]);
                }
            }
        }
        return result;
    }
}
