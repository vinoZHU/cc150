package cc150;

/**
 * Created by vino on 2017/8/12.
 */
public class 叠罗汉I {
    public static void main(String[] args){
        int[] men = {2,1,4,3,1,5,6};
        System.out.println(new 叠罗汉I().getHeight(men, 7));
    }
    public int getHeight(int[] men, int n) {
        // write code here
        int[] dp = new int[n];
        dp[0] = men[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (men[i] >= dp[index]) {
                dp[++index] = men[i];
            }
            else {
                int position = getPosition(dp, 0, index, men[i]);
                dp[position] = men[i];
            }
        }
        return index + 1;

    }

    private int getPosition(int[] dp, int low, int high, int man) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] > man) {
                high = mid;
            }
            else if (dp[mid] < man){
                low = mid + 1;
            }
            else {
                return mid;
            }

        }
        return low;
    }
}
