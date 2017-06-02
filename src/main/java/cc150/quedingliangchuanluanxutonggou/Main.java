package cc150.quedingliangchuanluanxutonggou;

import java.util.Arrays;

/**
 * Created by vino on 2017/6/1.
 *
 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 测试样例：
 "This is nowcoder","is This nowcoder"
 返回：true
 "Here you are","Are you here"
 返回：false
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().checkSam("This is nowcoder", "is This nowcoder"));
    }

    public boolean checkSam(String stringA, String stringB) {
        // write code here
        char[] a = stringA.toCharArray();
        char[] b = stringB.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}
