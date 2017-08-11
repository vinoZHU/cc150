package jianzhioffer;

import java.util.Arrays;

/**
 * Created by vino on 2017/8/10.
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] data = {1,4,5,6,7,8,9};
        new 调整数组顺序使奇数位于偶数前面().reOrderArray(data);
        System.out.println(Arrays.toString(data));
    }

    public void reOrderArray(int [] array) {
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if ((array[i] & 1) == 1)
                count++;
        }
        int index1 = 0;
        int index2 = count;
        for (int i = 0; i < length; i++) {
            if ((copy[i] & 1) == 1)
                array[index1++] = copy[i];
            else
                array[index2++] = copy[i];
        }

    }
    //方法二：类似冒泡，奇偶交换
}
