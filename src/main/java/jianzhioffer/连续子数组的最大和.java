package jianzhioffer;

/**
 * Created by vino on 2017/8/11.
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
