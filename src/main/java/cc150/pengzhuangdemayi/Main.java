package cc150.pengzhuangdemayi;

/**
 * Created by vino on 2017/6/6.
 * 在n个顶点的多边形上有n只蚂蚁，这些蚂蚁同时开始沿着多边形的边爬行，请求出这些蚂蚁相撞的概率。(这里的相撞是指存在任意两只蚂蚁会相撞)
 给定一个int n(3<=n<=10000)，代表n边形和n只蚂蚁，请返回一个double，为相撞的概率。
 测试样例：
 3
 返回：0.75
 *
 * //要想没有相撞，只有所有的蚂蚁朝一个方向走，要么顺时针，要么逆时针
 //每个蚂蚁都有两个选择，所有情况2的n次方种，其中满足条件的2种
 */
public class Main {
    public double antsCollision(int n) {
        // write code here
        return 1.0 - 1.0/(1 << (n-1));
    }
}
