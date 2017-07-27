package niuke;

/**
 * Created by vino on 2017/7/26.
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(new LCS().findLCS("1A2C3D4B56", 10, "B1D23CA45B6A", 12));
    }

    public int findLCS(String A, int n, String B, int m) {
        // write code here

        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        if (A.length() == 0 || B.length() == 0)
            return 0;
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (A.charAt(i) == B.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }
                    else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                    max = dp[i + 1][j + 1] > max ? dp[i + 1][j + 1] : max;
                }

            }
        }
        return max;

    }
}
