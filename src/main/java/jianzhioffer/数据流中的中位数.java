package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vino on 2017/8/8.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class 数据流中的中位数 {
    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int length = list.size();
        if (length % 2 != 0) {
            return (double)list.get(length / 2);
        }
        double tmp1 = list.get(length / 2);
        double tmp2 = list.get(length / 2 - 1);
        return (tmp1 + tmp2) / 2;
    }
}
