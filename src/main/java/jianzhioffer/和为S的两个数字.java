package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**[1,2,4,7,11,15],15
 * Created by vino on 2017/8/10.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 输出描述:
 对应每个测试案例，输出两个数，小的先输出。
 */
public class 和为S的两个数字 {
    public static void main(String[] args) {
        int[] data = {1,2,4,7,11,15};
        ArrayList<Integer> list = new 和为S的两个数字().FindNumbersWithSum(data, 15);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2)
            return list;
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        int number1 = 0;
        int number2 = 0;
        int min = Integer.MAX_VALUE;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                int tmp = min;
                min = Math.min(min, array[i] * array[j]);
                if (tmp > min) {
                    number1 = array[i];
                    number2 = array[j];
                }
                i++;
                j--;
            }
            else {
                if (array[i] + array[j] < sum) {
                    i++;
                }
                if (array[i] + array[j] > sum) {
                    j--;
                }
            }
        }
        if (number1 == 0 && number2 == 0)
            return list;
        list.add(number1);
        list.add(number2);
        return list;
    }
}
