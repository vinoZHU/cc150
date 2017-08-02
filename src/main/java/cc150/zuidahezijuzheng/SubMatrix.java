package cc150.zuidahezijuzheng;

/**
 * Created by vino on 2017/7/30.
 * 有一个正整数和负整数组成的NxN矩阵，请编写代码找出元素总和最大的子矩阵。请尝试使用一个高效算法。
 给定一个int矩阵mat和矩阵的阶数n，请返回元素总和最大的子矩阵的元素之和。保证元素绝对值小于等于100000，且矩阵阶数小于等于200。
 测试样例：
 [[1,2,-3],[3,4,-5],[-5,-6,-7]],3
 返回：10
 */
public class SubMatrix {
    public int sumOfSubMatrix(int[][] mat, int n) {
        int maxSum = Integer.MIN_VALUE;
        int sum[] = new int[mat[0].length];
        for(int i=0; i<mat.length; i++){//压缩的起点
            for(int j=0; j<sum.length; j++) sum[j]=0;//每次更换起点sum就重置，感觉还可改进
            for(int t=0; t<mat.length-i; t++){//步长，矩阵=起点+步长
                for(int j=0; j<sum.length; j++) sum[j]+=mat[i+t][j];//求上述矩阵的压缩和
                maxSum = Math.max(maxSum, getMaxSum(sum)); //压缩为一维求和，取最大值              
            }
        }
        return maxSum;
    }
    public int getMaxSum(int a[]){//常用，一维数组中连续子数组的最大和
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=0; i<a.length; i++){
            curSum += a[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum<0) curSum=0;
        }
        return maxSum;
    }
}
