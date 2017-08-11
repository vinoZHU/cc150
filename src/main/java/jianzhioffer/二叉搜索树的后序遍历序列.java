package jianzhioffer;

/**
 * Created by vino on 2017/8/11.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        System.out.println(new 二叉搜索树的后序遍历序列().VerifySquenceOfBST(new int[]{5,4,3,2,1}));
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return isBST(sequence, 0, sequence.length - 1);
    }
    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int i = end - 1;
        while (i >= start && sequence[i] > sequence[end])
            i--;

        for(int j = start; j <= i; j++) {
            if(sequence[j] > sequence[end])
                return false;
        }

        return isBST(sequence, start, i) && isBST(sequence, i + 1, end-1);

    }
}
