package niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vino on 2017/7/25.
 */
public class Zhizaohuiwen {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        String str = "abbaa";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, count + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        int jishu = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            if (count % 2 != 0)
                jishu += 1;
        }
        if (jishu == 0 || jishu == 1)
            System.out.println(1);
        else
            System.out.println(1 + jishu - 1);
    }
}
