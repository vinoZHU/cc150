package cc150.juzhensuansuchazhao;

import java.util.Arrays;

/**
 * Created by vino on 2017/6/30.
 * 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。
 给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 测试样例：
 [[1,2,3],[4,5,6]],2,3,6
 返回：[1,2]
 */
public class Main {

    public static void main(String[] args) {
        int[][] data = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(new Main().findElement(data, 4, 4, 14)));
    }

    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here

//        int low = 0;
//        int high = n - 1;
//
//        int row = -1;
//        if (n == 1)
//            row = 1;
//        if (high - low == 1) {
//            row = mat[high][0] > x ? low : high;
//        }
//
//        while (high - low > 1) {
//            int mid = (high + low) / 2;
//            if (mat[mid][0] < x) {
//                low = mid;
//            } else if (mat[mid][0] > x) {
//                high = mid;
//            }
//            else {
//                return new int[]{mid, 0};
//            }
//        }
//        if (row == -1){
//            row = mat[high][0] > x ? low : high;
//        }
//        low = 0;
//        high = m - 1;
//        while (low <= high) {
//            int mid = (high + low) / 2;
//            if (mat[row][mid] < x) {
//                low = mid + 1;
//            } else if (mat[row][mid] > x) {
//                high = mid - 1;
//            }
//            else {
//                return new int[]{row, mid};
//            }
//        }
//        return null;

        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] > x)
                col--;
            else if (mat[row][col] < x)
                row++;
            else
                return new int[]{row, col};
        }
        return null;
    }
}
