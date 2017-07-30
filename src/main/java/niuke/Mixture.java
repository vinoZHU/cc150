package niuke;

/**
 * Created by vino on 2017/7/30.
 *
 对于三个字符串A，B，C。我们称C由A和B交错组成当且仅当C包含且仅包含A，B中所有字符，且对应的顺序不改变。
 请编写一个高效算法，判断C串是否由A和B交错组成。
 给定三个字符串A,B和C，及他们的长度。请返回一个bool值，代表C是否由A和B交错组成。保证三个串的长度均小于等于100。
 测试样例：
 "ABC",3,"12C",3,"A12BCC",6
 返回：true
 */
public class Mixture {

    public static void main(String[] args) {
        System.out.println(new Mixture().chkMixture(
                "bcbccabccacccbcac", 17,
                "abbbacaabccbccaaaabbcbcbaaacccbaaba", 35,
                "babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac", 52
        ));
    }

    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        char[] c = C.toCharArray();
        boolean[][] dp = new boolean[a.length + 1][b.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= a.length; ++i) {
            if (a[i - 1] == c[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int j = 1; j <= b.length; ++j) {
            if (b[j - 1] == c[j - 1]) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= b.length; ++j) {
                if (dp[i - 1][j] && c[i + j - 1] == a[i - 1]) {
                    dp[i][j] = true;
                    continue;
                }
                if (dp[i][j - 1] && c[i + j - 1] == b[j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[a.length][b.length];
    }

}
