package cc150.qingchuhanglie;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by vino on 2017/6/1.
 *
 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 给定一个N阶方阵int[][](C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
 测试样例：
 [[1,2,3],[0,1,2],[0,0,1]]
 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class Main {

    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        Set<Integer> cleanRow = new HashSet<Integer>();
        Set<Integer> cleanColumn = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    cleanRow.add(i);
                    cleanColumn.add(j);
                }
            }
        }
        Iterator rowIterator = cleanRow.iterator();
        while (rowIterator.hasNext()) {
            int row = (Integer) rowIterator.next();
            for (int i = 0; i < n; i++) {
                mat[row][i] = 0;
            }
        }
        Iterator columnIterator = cleanColumn.iterator();
        while (columnIterator.hasNext()) {
            int column = (Integer) columnIterator.next();
            for (int i = 0; i < n; i++) {
                mat[i][column] = 0;
            }
        }
        return mat;
    }
}
