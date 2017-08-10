package jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vino on 2017/8/10.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(new 第一个只出现一次的字符().FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.trim().equals(""))
            return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
            else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return 0;
    }
}
