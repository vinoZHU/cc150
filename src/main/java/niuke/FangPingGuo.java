package niuke;

import java.util.Scanner;

/**
 * Created by vino on 2017/7/26.
 * 链接：https://www.nowcoder.com/questionTerminal/a2a1d0266629404fba582d416d84b6a0
 来源：牛客网

 参考了各位撸友的解析,我补充一点对自认为的难点的理解:
 # 难点: 当苹果大于盘子时,(这是大前提,注意哦) 我们怎么确定有多少种放法. 此时我们考虑了分类.
 # 思路来源: 分类计数原理:完成一件事情有n类办法,那么完成这件事共有N=m1+m2+…+m

 n

 种不同的方法.

 # 分类:
 分为有空盘和没有空盘的两种情况.
 # 检查分类
 1. 完备性
 是否囊括所有情况, 所有的放苹果方法,要么有空盘,要么没有空盘.
 2. 分类是否重复
 一类有空盘,一类无空盘,不会重复.
 # 分类后,我们如何操作可以保证满足分类条件
 1. 保证有空盘
 单独拿一个盘子不放,此时的情形,对于放法数而言,是不是相当于f(apple, plate-1).
 2. 保证没有空盘
 首先每个盘子放一个苹果,这样不就可以保证了,此时的情形,对于放法数而言,是不是相当于f(apple-plate,plate)
 */
public class FangPingGuo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(fun(m, n));
    }

    static int fun(int m, int n) //m个苹果放在n个盘子中共有几种方法
    {
        if(m==0 || n==1)
            return 1;
        if(n>m)
            return fun(m,m);
        else
            return fun(m,n-1)+fun(m-n,n);
    }
}
