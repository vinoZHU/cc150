package niuke;

/**
 * Created by vino on 2017/8/14.
 */
public class 股票交易日 {

    public static void main(String[] args) {
        int[] data = {10,22,5,75,65,80};
        System.out.println(new 股票交易日().maxProfit(data, 6));
    }

    public int maxProfit(int[] prices, int n) {
        // write code here
        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        int maxRight = prices[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (prices[i] < maxRight) {
                rightMax[i] = Math.max(maxRight - prices[i], rightMax[i + 1]);
            }
            else {
                maxRight = prices[i];
                rightMax[i] = rightMax[i + 1];
            }
        }
        int minLeft = prices[0];
        int maxProfit = rightMax[1];
        int firstProfit = 0;
        for (int i = 1; i < n - 1; i++) {
            if (prices[i] > minLeft) {
                firstProfit = Math.max(firstProfit, prices[i] - minLeft);
                maxProfit = Math.max(maxProfit, firstProfit + rightMax[i + 1]);
            }
            else {
                minLeft = prices[i];
            }
        }
        return maxProfit;
    }

}
