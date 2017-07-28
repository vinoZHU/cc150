package niuke;

/**
 * Created by vino on 2017/7/28.
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 测试样例：
 [2,1,4,3,1,5,6],7
 返回：4
 */
public class AscentSequence {
    public static void main(String[] args) {
        int[] data = {203,39,186,207,83,80,89,237,247};
        System.out.println(new AscentSequence().findLongest(data, 9));
    }

    public int findLongest(int[] A, int n) {
        // write code here
        int max = 1;
        int[] sub = new int[n];
        sub[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > sub[max - 1]) {
                sub[max] = A[i];
                max++;
            }
            else {
                int position = findInsertPos(sub, A[i], 0, max - 1);
                sub[position] = A[i];
            }
        }
        return max;
    }

    private int findInsertPos(int[] B, int n, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;// 直接使用(high + low) / 2 可能导致溢出
            if (B[mid] < n) {
                start = mid + 1;
            } else if (B[mid] > n) {
                end = mid ;
            } else {
                return mid;
            }
        }
        return start;
    }
}
