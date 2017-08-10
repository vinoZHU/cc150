package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class 左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(new 左旋转字符串().LeftRotateString("abcXYZdef", 3));
    }
    public String LeftRotateString(String str,int n) {
        if (str == null || str.trim().equals(""))
            return str;
        char[] newChars = new char[str.length()];
        char[] oldChars = str.toCharArray();
        for (int i = 0; i < newChars.length - n; i++) {
            newChars[i] = oldChars[i + n];
        }
        for (int i = newChars.length - n; i < newChars.length; i++) {
            newChars[i] = oldChars[i - (newChars.length - n)];
        }
        return new String(newChars);
    }
}
