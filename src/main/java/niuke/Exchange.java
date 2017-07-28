package niuke;

/**
 * Created by vino on 2017/7/28.
 * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。
 给定一个int数组changes，代表所以零钱，同时给定它的大小n，另外给定一个正整数x，请返回组成x的方案数，保证n小于等于100且x小于等于10000。
 测试样例：
 [5,10,25,1],4,15
 返回：6
 测试样例：
 [5,10,25,1],4,0
 返回：1
 */
public class Exchange {

    public int countWays(int[] changes, int n, int x) {
        // write code here
        //dp[i][j]表示使用changes[0~i]的钱币组成金额j的方法数
        int[][] dp=new int[n][x+1];
        //第一列全为1，因为组成0元就只有一种方法
        for(int i=0;i<n;i++)
            dp[i][0]=1;
        //第一行只有changes[0]的整数倍的金额才能有1种方法
        for(int j=0;j*changes[0]<=x;j++){
            dp[0][j*changes[0]]=1;
        }
        //从位置(1,1)开始遍历
        for(int i=1;i<n;i++){
            for(int j=1;j<=x;j++){
                //关键：使用0~i的钱币组成j-changes[i]金额的方法数+使用0~i-1钱币组成j的方法数
                dp[i][j]=dp[i-1][j]+(j-changes[i]>=0?dp[i][j-changes[i]]:0);
            }
        }

        return dp[n-1][x];
    }
}
