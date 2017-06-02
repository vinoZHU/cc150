package cc150.xiangsufanzhuan;

/**
 * Created by vino on 2017/6/1.
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 测试样例：
 [[1,2,3],[4,5,6],[7,8,9]],3
 返回：[[7,4,1],[8,5,2],[9,6,3]]

 首先上下翻转，再按照主对角线翻转
 1 2 3                 7 8 9            7 4 1
 4 5 6        —>       4 5 6    --->    8 5 2
 7 8 9                 1 2 3            9 6 3
 */
public class Main {

    public static void main(String[] args) {

    }

    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        //上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(mat[i], j, mat[n - i - 1], j);
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(mat[i], j, mat[j], i);
            }
        }
        return mat;

    }

    private void swap(int[] a, int aIndex, int[] b, int bIndex) {
        int tmp = a[aIndex];
        a[aIndex] = b[bIndex];
        b[bIndex] = tmp;
    }
}
