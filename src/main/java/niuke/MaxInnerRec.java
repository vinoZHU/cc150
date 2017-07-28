package niuke;

/**
 * Created by vino on 2017/7/28.
 *
 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 测试样例：
 [2,7,9,4,1],5
 返回：14
 */
public class MaxInnerRec {
    public static void main(String[] args) {
        int[] data = {2,7,9,4,1};
        System.out.println(new MaxInnerRec().countArea(data, 5));
    }

    public int countArea(int[] A, int n) {
        // write code here
        int i,j,L1,L2,area;
        int max=0;
        for(i=0;i<n;i++)
        {
            L1=0;L2=0;
            for(j=i;j<n;j++)
            {
                if(A[j]>=A[i])L1++;
                else break;

            }
            for(j=i-1;j>=0;--j)
            {
                if(A[j]>=A[i])L2++;
                else break;
            }
            area=(L1+L2)*A[i];
            if(area>max)max=area;
        }
        return max;
    }
}
