package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by vino on 2017/8/10.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 输出描述:
 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class 和为S的连续正数序列 {
    public static void main(String[] args) {
        new 和为S的连续正数序列().FindContinuousSequence(9);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum == 3) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            lists.add(list);
            return lists;
        }
        for (int i = 1; i <= sum / 2; i++) {
            int tmp = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j <= sum / 2 + 1; j++) {
                tmp += j;
                list.add(j);
                if (tmp == sum) {
                    lists.add(list);
                    break;
                }
                if (tmp > sum) {
                    break;
                }
            }
        }
        return lists;
    }
}
