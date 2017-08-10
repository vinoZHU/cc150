package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(new 二进制中1的个数().NumberOf1(10));
    }

    public int NumberOf1(int n) {
        //最优解

        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
        //正解
//        if (n == 0)
//            return 0;
//        while ((n & 1) == 0) {
//            n >>>= 1;
//        }
//        int count = 1;
//        n >>>= 1;
//        while (n > 0) {
//            if ((n & 1) == 1)
//                count++;
//            n >>= 1;
//        }
//        return count;
    }
}
