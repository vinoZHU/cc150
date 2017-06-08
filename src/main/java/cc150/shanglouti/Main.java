package cc150.shanglouti;

/**
 * Created by vino on 2017/6/8.
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 测试样例：
 1
 返回：1
 *
 * 链接：https://www.nowcoder.com/questionTerminal/7f0661ace6df48d0af3f924950d57126
 来源：牛客网

 a[i]=((a[i-1]+a[i-2])%1000000007+a[i-3])%1000000007
 的解释：
 取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
 所以(a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X   用X代替1000000007
 这样就使得a[i-1]、a[i-2]、a[i-1]+a[i-2]都没有溢出，之后再与a[i-3]相加之后取模，使得全部结果没有溢出。

 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().countWays(5));
    }

    public int countWays(int n) {
        // write code here
        int[] a = new int[100000];
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        for(int i = 4; i <= n; i++)
            a[i]=((a[i-1]+a[i-2])%1000000007+a[i-3])%1000000007;
        return a[n];
    }
}
