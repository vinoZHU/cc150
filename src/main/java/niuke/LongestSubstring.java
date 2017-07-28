package niuke;

import cc150.erdegeshu.Main;

/**
 * Created by vino on 2017/7/27.
 *
 对于两个字符串，请设计一个时间复杂度为O(m*n)的算法(这里的m和n为两串的长度)，求出两串的最长公共子串的长度。
 这里的最长公共子串的定义为两个序列U1,U2,..Un和V1,V2,...Vn，其中Ui + 1 == Ui+1,Vi + 1 == Vi+1，同时Ui == Vi。
 给定两个字符串A和B，同时给定两串的长度n和m。
 测试样例：
 "1AB2345CD",9,"12345EF",7
 返回：4
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().findLongest("1ab23456cd", 9, "12345ef", 7));
    }
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        char[] achars = A.toCharArray();
        char[] bchars = B.toCharArray();

        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (achars[i] == bchars[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (bchars[j] == achars[0]) {
                dp[0][j] = 1;
                max = 1;
            }
        }
        for (int k = 1; k < n; k++) {
            for (int p = 1; p < m; p++) {
                if (achars[k] == bchars[p]) {
                    dp[k][p] = dp[k - 1][p - 1] + 1;
                    max = max > dp[k][p] ? max : dp[k][p];
                }
            }
        }
        return max;
    }
}
