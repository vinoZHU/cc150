package niuke;

import java.util.Arrays;

/**
 * Created by vino on 2017/7/29.
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 测试样例：
 "abc1234321ab",12
 返回：7
 */
public class Palindrome {

    public static void main(String[] args) {
        String data = "acbdcbbbdbdaaccbcacdacdccababcddabddaaaaaaabdbabcdddaacabacbacbbdabdacddbbadaacbbdcbccacacdabcabacacbbbdcccacdcdcdcbcbabdcdacdddbbabcaccddddddabdacaabccdcabcbcbabacaaaccaccaddabbdadcdacdcdbaadbcabdcdcaaacbcadccbbddbaddcaddcaadcbbcbbdcbdadcddabdddcdbddbbdabaaddcaadd";
        System.out.println(new Palindrome().getLongestPalindrome(data, 265));
    }

    public int getLongestPalindrome(String A, int n) {
        // write code here
//        char[] achars = A.toCharArray();
//        int length = achars.length;
//        char[] bchars = new char[length];
//        for (int i = 0; i < length; i ++) {
//            bchars[i] = achars[length - 1 - i];
//        }
//        int[][] dp = new int[length][length];
//        int max = 0;
//        for (int i = 0; i < length; i++) {
//            if (bchars[0] == achars[i]) {
//                dp[i][0] = 1;
//                max = 1;
//            }
//            if (achars[0] == bchars[i]) {
//                dp[0][i] = 1;
//                max = 1;
//            }
//        }
//        for (int j = 1; j < length; j++) {
//            for (int k = 1; k < length; k++) {
//                if (achars[j] == bchars[k]) {
//                    dp[j][k] = dp[j - 1][k - 1] + 1;
//                    max = Math.max(max, dp[j][k]);
//                }
//            }
//        }
//        return max;

        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        char[] a = A.toCharArray();
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                if (len == 2 && a[i] == a[j]) {
                    dp[i][j] = len;
                    max = 2;
                    continue;
                }
                if (a[i] == a[j] && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = len;
                    max = len;
                }
            }
        }
        return max;
    }
}
