package cc150.gaoduzuixiaodeBST;

/**
 * Created by vino on 2017/6/4.
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
public class Main {

    public static void main(String[] args) {
        int[] vals = {1,2,3,4,5,6,7,8};
        System.out.println(new Main().buildMinimalBST(vals));
    }
    public int buildMinimalBST(int[] vals) {
        // write code here
        int length = vals.length;
        if (length == 1)
            return 1;
        if (length == 2)
            return 2;
        int index = length / 2;
        int height = 1;
        while (index > 0) {
            height++;
            index /= 2;
        }
        return height;
    }
}
