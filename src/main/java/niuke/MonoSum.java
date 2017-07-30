package niuke;

/**
 * Created by vino on 2017/7/29.
 * 现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。
 * 请设计一个高效算法，计算数组的单调和。
 给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和不会超过int范围。
 测试样例：
 [1,3,5,2,4,6],6
 返回：27
 */
public class MonoSum {

    public int calcMonoSum(int[] A, int n) {
        // write code here

        int count = 0;
        for(int i = 1 ; i < n ;i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(A[j]<=A[i]){
                    count += A[j];
                }
            }
        }
        return count;
    }



}
