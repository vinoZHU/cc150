package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vino on 2017/8/11.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.trim().equals("")) {
            return list;
        }
        help(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void help(char[] strs, int i, ArrayList<String> list) {
        if (i == strs.length - 1) {
            String str = new String(strs);
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        else {
            for (int j = i; j < strs.length; j++) {
                swap(strs, i, j);
                help(strs, i + 1, list);
                swap(strs, i, j);
            }
        }
    }
    private void swap(char[] cs, int i, int j) {
        if(i < 0 || i > cs.length - 1 || j < 0 || j > cs.length - 1)
            return;
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
