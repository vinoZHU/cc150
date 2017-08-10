package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int target = 1;
        int[][] data = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new 二维数组中的查找().Find(target, data));
    }
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        for(int i = 0; i < array.length; i++){
            if (array[i][array[0].length - 1] == target)
                return true;
            if (array[i][array[0].length - 1] > target) {
                return doFind(array, target, i, array[0].length - 2);
            }
        }
        return false;
    }
    private boolean doFind(int [][] array,int target, int i, int j) {
        if (i < 0 || i >= array.length || j < 0 || j >= array[0].length)
            return false;
        if (array[i][j] == target)
            return true;
        boolean find = false;
        if (array[i][j] > target) {
            if (j > 0 && array[i][j] >= target)
                find = doFind(array, target, i, j - 1);
        }
        else {
            if (i < array.length - 1 &&  array[i][j] <= target)
                find = doFind(array, target, i + 1, j);
        }
        return  find;
    }
}
