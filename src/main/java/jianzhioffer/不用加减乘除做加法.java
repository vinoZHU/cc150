package jianzhioffer;

/**
 * Created by vino on 2017/8/9.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class 不用加减乘除做加法 {

    public static void main(String[] args) {
        System.out.println(new 不用加减乘除做加法().Add(-6, -2));
    }

    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1 ^ num2;//不进位加法
            num2 = (num1 & num2) << 1;//进位
            num1 = temp;
        }
        return num1;
    }
}
