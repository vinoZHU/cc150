package cc150.fanzhuanzichuan;

/**
 * Created by vino on 2017/6/1.
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 测试样例：
 "Hello world","worldhello "
 返回：false
 "waterbottle","erbottlewat"
 返回：true
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().checkReverseEqual(
                "ookvnorsiwwddjkpqasgbqjqrgsyriuxsruxidwprrxagjxzbwwgztsgndyfoelcgfzqzxzximtdwjlkhouxqrdzdguhxweqkvqabcltywygpbgeprmhbltnhkhynvpuszoqdrspwldgecrbvzsiywkfzphczpxyeyzhdhnegmodldikwnjhlwer",
                "sgndyfoelcgfzqzxzximtdwjlkhouxqrdzdguhxweqkvqabcltywygpbgeprmhbltnhkhynvpuszoqdrspwldgecrbvzsiywkfzphczpxyeyzhdhnegmodldikwnjhlwerookvnorsiwwddjkpqasgbqjqrgsyriuxsruxidwprrxagjxzbwwgzt"));
    }

    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        int j = s1.indexOf(s2.charAt(0));
        return check(j, s1, s2);

    }

    private boolean check(int j, String s1, String s2) {
        int nextStart = j + 1;
        if (j == -1) {
            return false;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        int i = 0;
        while (i < length2 - 1) {
            if (j == length1 - 1) {
                j = 0;
            }
            else {
                j++;
            }
            i++;
            if (s1.charAt(j) != s2.charAt(i)) {
                j = s1.indexOf(s2.charAt(0), nextStart);
                return check(j, s1, s2);
            }
        }
        return true;
    }
}
