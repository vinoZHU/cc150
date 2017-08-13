package niuke;

import java.util.Scanner;

/**
 * Created by vino on 2017/8/13.
 */
public class 最大间隔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int[] dis = new int[n - 1];
            for (int i = 1; i < n; ++i) {
                dis[i - 1] = array[i] - array[i - 1];
                max = Math.max(dis[i - 1], max);
            }
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < n - 1; ++i) {
                int tmp = Math.max(max, dis[i] + dis[i - 1]);
                result = Math.min(result, tmp);
            }
            System.out.println(result);
        }

    }
}
