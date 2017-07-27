package niuke;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by vino on 2017/7/25.
 * 给定一个字符串S，可以通过在字符串的任意位置插入字符，使其变为回文串。求最少插入字符的数量。

 例如：

 ab -> bab  1

 aa -> aa    0

 abca -> acbca 1
 */
public class Huiwen {

    public static void main(String[] args) {

        String str = "dcabad";
        String str2 = StringUtils.reverse(str);
        int length = str.length();
        int[][] dp = new int[length + 1][length + 1];
        if (str.length() == 1)
            System.out.println(0);
        else if (str.length() == 2) {
            System.out.println(str.charAt(0) == str.charAt(1) ? "0" : 1);
        }
        else {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (str.charAt(i) == str2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }
                    else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }

            }
        }
        for (int i = 0; i < length + 1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }
}
