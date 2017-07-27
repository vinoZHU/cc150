package niuke;

/**
 * https://www.nowcoder.com/questionTerminal/9370d298b8894f48b523931d40a9a4aa
 * Created by vino on 2016/10/13.
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，
 * 已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，
 * 收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 输入例子:

 3,8,5,1,7,8

 输出例子:

 12
 */
public class Gushi {

    public static void main(String[] args){
        int[] prices = {3,8,5,1,7,8};
        System.out.println(calculateMax(prices));
    }

    //动态规划?:从左到右扫描一遍,dpl[i]表示到第i天最大的收益;计算最大收益:
    //用minI表示取得最大收益时较小值的位置
    //若arr[i+1]>arr[i],则dpl[i+1]=dp[i] 或者=arr[i+1]-arr[minI]
    //若arr[i+1]<arr[i],dpl[i+1]=dp[i],若arr[i+1]<arr[minI],则更新minI为arr[i+1]
    //再从右往左扫描计算dpr[i],同理
    public static int calculateMax(int[] prices) {
        if(prices==null || prices.length==0 || prices.length<2 || prices.length>100){
            return 0;
        }

        int len = prices.length;
        int[] dpl = new int[len];
        dpl[0] = 0;
        int minI = 0;
        for(int i=1; i<len; i++){   //从左到右扫描一遍填充dpl数组
            if(prices[i]>prices[i-1]){
                dpl[i] = Math.max(prices[i]-prices[minI],dpl[i-1]);
            } else{
                dpl[i] = dpl[i-1];
                if(prices[i]<prices[minI])
                    minI = i;
            }
        }

        int[] dpr = new int[len];
        dpr[len-1] = 0;
        int maxI = len-1;
        for(int i=len-2; i>=0; i--){//从右到左扫描一遍填充dpr数组
            if(prices[i]<prices[i+1]){
                dpr[i] = Math.max(prices[maxI]-prices[i], dpr[i+1]);
            } else{
                dpr[i] = dpr[i+1];
                if(prices[i]>prices[maxI]){
                    maxI = i;
                }
            }
        }

        int res = 0;
        for(int i=0; i<len; i++){ //比较得出最大值
            res = Math.max(dpl[i]+dpr[i], res);
        }
        return res;

    }
}
