package cc150.zuijinggonggongzuxian;

import java.util.ArrayList;

/**
 * Created by vino on 2017/6/4.
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 测试样例：
 2，3
 返回：1
 */
public class Main {

    public int getLCA(int a, int b) {
        // write code here
        ArrayList<Integer> aP = new ArrayList<>();
        ArrayList<Integer> bP = new ArrayList<>();
        while ( a != 1) {
            a /= 2;
            aP.add(a);
        }
        while (b != 1) {
            b /= 2;
            bP.add(b);
        }
        for (Integer i : aP) {
            if (bP.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
