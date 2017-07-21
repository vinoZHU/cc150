package cc150.zhengshuduichazhao;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by vino on 2017/7/21.
 *
 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 测试样例：
 [1,2,3,4,5],5,6
 返回：2
 */
public class Main {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        System.out.println(new Main().countPairs(data, 5, 6));
    }

    public int countPairs(int[] A, int n, int sum) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            if (map.containsKey(A[i])) {
                int count = map.get(A[i]);
                map.put(A[i], count + 1);
            }
            else {
                map.put(A[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int c = map.get(A[i]);
            if (map.containsKey(sum - A[i]) && map.get(sum - A[i]) != -1) {
                if (A[i] * 2 == sum && c > 1) {
                    for (int k = 1; k <= c - 1; k++) {
                        count += k;
                    }
                    map.put(A[i], -1);
                } else if (A[i] * 2 == sum && c == 1) {
                    map.put(A[i], -1);
                }
                else {
                    count += (c * map.get(sum - A[i]));
                }
                map.put(sum - A[i], -1);
            }
            map.put(A[i], -1);
        }
        return count;
    }
}
