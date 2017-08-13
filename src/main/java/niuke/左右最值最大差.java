package niuke;

/**
 * Created by vino on 2017/8/12.
 */
public class 左右最值最大差 {

    public static void main(String[] args) {
        int[] data = {2,7,3,1,1};
        System.out.println(new 左右最值最大差().findMaxGap(data, 5));
    }
    public int findMaxGap(int[] A, int n) {
        // write code here
        int[] maxRight = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i > 0; i--) {
            max = Math.max(max, A[i]);
            maxRight[i] = max;
        }
        int maxLeft = 0;
        int abs = Integer.MIN_VALUE;
        for (int k = 0; k < n - 1; k++) {
            maxLeft = Math.max(maxLeft, A[k]);
            abs = Math.max(abs, Math.abs(maxLeft - maxRight[k + 1]));
        }
        return abs;
    }
}
