package jianzhioffer;

/**
 * Created by vino on 2017/8/9.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class 构建乘积数组 {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int result = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j)
                    result *= A[j];
            }
            B[i] = result;
        }
        return B;
    }
}
