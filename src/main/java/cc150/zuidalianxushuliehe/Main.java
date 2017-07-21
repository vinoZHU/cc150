package cc150.zuidalianxushuliehe;

/**
 * Created by vino on 2017/7/21.
 */
public class Main {

    public static void main(String[] args) {

    }

    public int getMaxSum(int[] A, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
