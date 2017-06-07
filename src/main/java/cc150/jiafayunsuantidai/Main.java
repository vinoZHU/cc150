package cc150.jiafayunsuantidai;

/**
 * Created by vino on 2017/6/6.
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。
 测试样例：
 1,2,1
 返回：2
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().calc(5, 7, -1));
    }
    public int calc(int a, int b, int type) {
        // write code here
        switch (type) {
            case 1:
                int step = a;
                while (b > 1) {
                    a += step;
                    b--;
                }
                return a;
            case 0:
                if (a < b)
                    return 0;
                if (a == b)
                    return 1;
                int n = 1;
                while (a > b) {
                    if (calc(b, n, 1) <= a && calc(b, n + 1, 1) > a) {
                        return n;
                    }
                    n++;
                }
                break;
            case -1:
                int n2 = 0;
                if (a == b)
                    return n2;
                int step2 = b;
                if (a > b) {
                    n2 = 1;
                    while (a > b) {
                        b = step2 + n2;
                        n2++;
                    }
                    n2--;
                }
                else {
                    n2 = -1;
                    while (a < b) {
                        b = step2 + n2;
                        n2--;
                    }
                    n2++;
                }
                return n2;

            default:
                break;
        }
        return -1;
    }
}
