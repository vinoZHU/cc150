package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by vino on 2017/8/11.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {
    private ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1,2,4,3}};

    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        if (matrix == null)
            return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        while (row > start * 2 && col > start * 2) {
            printCircle(matrix, row, col, start);
            start++;
        }
        return list;

    }

    private void printCircle(int[][] matrix, int rows, int columns, int start) {

        // 从左到右打印一行
        for(int i = start; i < columns - start; i++)
            list.add(matrix[start][i]);
        // 从上到下打印一列
        for(int j = start + 1; j < rows - start; j++)
            list.add(matrix[j][columns - start - 1]);
        // 从右到左打印一行
        for(int m = columns - start - 2; m >= start && rows - start - 1 > start; m--)
            list.add(matrix[rows - start - 1][m]);
        // 从下到上打印一列
        for(int n = rows - start - 2; n >= start + 1 && columns - start - 1 > start; n--)
            list.add(matrix[n][start]);

    }
}
