package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 变态跳台阶 {

    public int JumpFloorII(int target) {
        if (target == 1 || target == 2 || target == 0)
            return target;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = i; j > 0; j--) {
                dp[i] += dp[i - j];
            }
        }
        return dp[target];
    }
}
