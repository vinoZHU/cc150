package niuke;

import java.util.Scanner;

/**
 * Created by vino on 2017/7/25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        int n = length - 2;
        char[] chars = str.toCharArray();
        boolean flag = true;
        while (n > 0) {
            for (int j = 0; j < n / 2; j++) {
                if (chars[j] != chars[j + n / 2]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                n -= 2;
                flag = true;
            }
            else {
                System.out.println(n);
                return;
            }
        }
        System.out.println(0);

    }
}
