package cc150.zhaochuzifucuan;

/**
 * Created by vino on 2017/6/30.
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
 测试样例：
 ["a","b","","c","","d"],6,"c"
 返回：3
 */
public class Main {

    public static void main(String[] args) {
        String[] data = {"a","b","","c","","d"};
        System.out.println(new Main().findString(data, 6, "c"));
    }

    public int findString(String[] str, int n, String x) {
        // write code here
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (str[mid].equals("")) {
                while (mid++ < n) {
                    if (str[mid].equals(""))
                        continue;
                    if (str[mid].compareTo(x) > 0) {
                        high = mid - 1;
                        break;

                    } else if (str[mid].compareTo(x) < 0) {
                        low = mid + 1;
                        break;
                    }
                    else {
                        return mid;
                    }
                }
            }
            else if (str[mid].compareTo(x) > 0) {
                high = mid - 1;

            } else if (str[mid].compareTo(x) < 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
