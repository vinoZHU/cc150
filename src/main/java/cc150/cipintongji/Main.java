package cc150.cipintongji;

import java.util.HashMap;

/**
 * Created by vino on 2017/7/21.
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */
public class Main {

    public int getFrequency(String[] article, int n, String word) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(article[i])) {
                int count = map.get(article[i]);
                map.put(article[i], count + 1);
            }
            else {
                map.put(article[i], 1);
            }
        }
        return map.containsKey(word) ? map.get(word) : 0;
    }
}
