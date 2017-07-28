package niuke;

/**
 * Created by vino on 2017/7/28.
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
 * 给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 测试样例：
 [10,22,5,75,65,80],6
 返回：87
 */
public class Stock {

    public static void main(String[] args) {
        int[] data = {10,22,5,75,65,80};
        System.out.println(new Stock().maxProfit(data, 6));
    }

    public int maxProfit(int[] prices, int n) {
        // write code here

//        int firstBuyProfit=Integer.MIN_VALUE;
//        int firstSaleProfit=Integer.MIN_VALUE;
//        int secondBuyProfit=Integer.MIN_VALUE;
//        int secondSaleProfit=Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            firstBuyProfit=Math.max(firstBuyProfit, -prices[i]);
//            firstSaleProfit=Math.max(firstSaleProfit, firstBuyProfit+prices[i]);
//            secondBuyProfit=Math.max(secondBuyProfit, firstSaleProfit-prices[i]);
//            secondSaleProfit=Math.max(secondSaleProfit, secondBuyProfit+prices[i]);
//        }
//        return secondSaleProfit;

        int[] before = new int[n];
        int[] after = new int[n];

        int minBuy = prices[0];
        for (int i = 1; i < n; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            before[i] = Math.max(before[i - 1], prices[i] - minBuy);
        }
        int maxSell = prices[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            maxSell = Math.max(maxSell, prices[j]);
            after[j] = Math.max(after[j + 1], maxSell - prices[j]);
        }

        int max = 0;
        for (int k = 0; k < n; k++) {
            max = Math.max(max, before[k] + after[k]);
        }
        return max;
    }
}
