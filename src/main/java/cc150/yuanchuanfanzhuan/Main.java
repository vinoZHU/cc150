package cc150.yuanchuanfanzhuan;

/**
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 测试样例：
 "This is nowcoder"
 返回："redocwon si sihT"
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().reverseString("This is nowcoder"));
    }
    public String reverseString(String iniString) {
        // write code here
        int length = iniString.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[length - i - 1] = iniString.charAt(i);
        }
        return new String(chars);
    }
}
