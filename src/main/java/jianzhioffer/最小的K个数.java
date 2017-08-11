package jianzhioffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by vino on 2017/8/11.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        int[] data = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = new 最小的K个数().GetLeastNumbers_Solution(data, 4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k)
            return list;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : input) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        while (k > 0) {
            list.add(iterator.next());
            k--;
        }
        return list;
    }
}
