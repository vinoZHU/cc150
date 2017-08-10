package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 二分快速幂
 * 要求 a^n，如果知道了 a^(n/2) 次方的话，再来个平方就可以了。
 即
 如果n是偶数，则A=a^(n/2) ； A=A*A.。
 如果n是奇数 , 则A=a^((n-1)/2) ； A=a*A*A。
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(new 数值的整数次方().Power(2, 5));
    }
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        if (exponent == -1)
            return 1 / base;
        double res = 1;
        double cur = base;
        int e = Math.abs(exponent);
        while (e > 0) {
            if ((e & 1) == 1) {
                res *= cur;
            }
            cur *= cur;
            e >>= 1;
        }
        return exponent > 0 ? res : 1 / res;
    }
}
