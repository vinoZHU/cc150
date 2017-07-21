package cc150.jiechenweiling;

/**
 * Created by vino on 2017/7/21.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().getFactorSuffixZero(5));
    }

    public int getFactorSuffixZero(int n) {
        // write code here
        if (n < 5)
            return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                count++;
                j /= 5;
            }
        }
        return count;
    }
}
