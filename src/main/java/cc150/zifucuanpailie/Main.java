package cc150.zifucuanpailie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by vino on 2017/6/15.
 * 编写一个方法，确定某字符串的所有排列组合。
 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 测试样例：
 "ABC"
 返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().getPermutation("ABC"));
    }

    public ArrayList<String> getPermutation(String A) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        if (A == null || A.length() == 0)
            return result;
        result.add("");
        for (int i = 0; i < A.length(); i++) {
            Iterator iterator = result.iterator();
            ArrayList<String> newResult = new ArrayList<>();
            while (iterator.hasNext()) {
                String tmp = (String) iterator.next();
                insert(newResult, tmp, A.substring(i, i + 1));
            }
            result = newResult;
        }
        Collections.sort(result);
        Collections.reverse(result);
        return result;

    }

    private void insert(ArrayList<String> result, String origin, String insertString) {
        if (origin.equals("")) {
            origin = insertString;
            result.add(origin);
        }
        else {
            result.add(insertString + origin);
            for (int i = 0; i < origin.length(); i++) {
                result.add(origin.substring(0, i + 1) + insertString + origin.substring(i + 1, origin.length()));
            }
        }

    }

}
