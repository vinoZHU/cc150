package cc150.bianweicipaixu;

import java.util.*;

/**
 * Created by vino on 2017/6/29.
 * 请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。
 给定一个string的数组str和数组大小int n，请返回排序合并后的数组。保证字符串串长小于等于20，数组大小小于等于300。
 测试样例：
 ["ab","ba","abc","cba"]
 返回：["ab","abc"]
 */
public class Main {

    public static void main(String[] args) {
        String[] strings = {"eb","ba","bca","abc"};
        System.out.println(new Main().sortStrings(strings, 4));
    }

    public ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
        List<MyString> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MyString tmp = new MyString(str[i]);
            if (!list.contains(tmp)) {
                list.add(tmp);
            }
            else {
                int index = list.indexOf(tmp);
                if (list.get(index).value.compareTo(tmp.value) > 0) {
                    list.set(index, tmp);
                }
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            MyString myString = (MyString) iterator.next();
            arrayList.add(myString.value);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    class MyString {
        String value;
        public MyString(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyString))
                return false;
            if (obj == this)
                return true;
            MyString tmp = (MyString) obj;
            char[] v1 = this.value.toCharArray();
            char[] v2 = tmp.value.toCharArray();
            Arrays.sort(v1);
            Arrays.sort(v2);
            return Arrays.equals(v1, v2);
        }

    }
}
