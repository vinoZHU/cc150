package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(new 斐波那契数列().Fibonacci(3));
    }
    public int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
