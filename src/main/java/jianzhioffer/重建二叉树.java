package jianzhioffer;

/**
 * Created by vino on 2017/8/10.
 *
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;
        if (pre.length != in.length)
            return null;
        return buildTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }
    private int findPosition(int[] inorder,int istart,int iend,int r){
        for(int i=istart;i<=iend;i++)
            if(inorder[i] == r)
                return i;
        return -1;
    }
    private TreeNode buildTree(int[] preorder,int pstart,int pend,int[] inorder,int istart,int iend){
        if(pstart > pend){
            return null;
        }
        int r = preorder[pstart];
        int position = findPosition(inorder,istart,iend,r);
        TreeNode root = new TreeNode(r);
        //左子树
        // 前序遍历的左子树 起始位置：pstart + 1 结束位置：pstart + (position - istart)
        // 中序遍历的左子树 起始位置:istart 结束位置 position -1
        root.left = buildTree(preorder,pstart + 1,pstart + (position -istart),inorder,istart,position-1);
        // 右子树
        // 前序遍历的右子树 起始位置 pstart + (position - istart) + 1 结束位置：pend
        // 中序遍历的右子树 起始位置:position + 1 结束位置：iend
        root.right = buildTree(preorder,pstart + (position -istart) + 1,pend,inorder,position + 1,iend);
        return root;
    }
}
