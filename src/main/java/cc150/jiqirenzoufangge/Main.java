package cc150.jiqirenzoufangge;

/**
 * Created by vino on 2017/6/8.
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 测试样例：
 2,2
 返回：2

 走的是格点，2 X 2 就只有四个格点。那就只有两种走法
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().countWays(2, 2));
    }

    public int countWays(int x, int y) {
        // write code here

        if (x == 1 && y == 1)
            return 1;
        if (x == 1)
            return countWays(x, y - 1);
        if (y == 1)
            return countWays(x - 1, y);
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
