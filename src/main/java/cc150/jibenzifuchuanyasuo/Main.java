package cc150.jibenzifuchuanyasuo;

/**
 * Created by vino on 2017/6/1.
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 测试样例
 "aabcccccaaa"
 返回："a2b1c5a3"
 "welcometonowcoderrrrr"
 返回："welcometonowcoderrrrr"
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().zipString("welcometonowcoderrrrr"));
    }

    public String zipString(String iniString) {
        // write code here
        int length = iniString.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 1;
        while (j < length) {
            if (iniString.charAt(i) != iniString.charAt(j)) {
                sb.append(iniString.charAt(i));
                sb.append(j - i);
                i = j;
                j++;
            }
            else {
                if (j == length - 1) {
                    sb.append(iniString.charAt(i));
                    sb.append(j - i + 1);
                    break;
                }
                else {
                    j++;
                }
            }
        }
        String zip = sb.toString();
        return zip.length() < length ? zip : iniString;
    }
}
