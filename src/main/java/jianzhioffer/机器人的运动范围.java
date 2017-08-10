package jianzhioffer;


/**
 * Created by vino on 2017/8/8.
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围 {

    public static void main(String[] args) {
        System.out.println(new 机器人的运动范围().movingCount(10, 1, 100));
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return bfs(threshold, rows, cols, 0, 0, visited);

    }

    private int bfs(int threshold, int rows, int cols, int x, int y, boolean[][] visited) {
        if (x >= rows || y >= cols)
            return 0;
        int flag = 0;
        if (canReach(x, y, threshold)) {
            flag = 1;
            visited[x][y] = true;
        }
        int tmp1 = 0;
        int tmp2 = 0;
        if (x + 1 < rows && !visited[x + 1][y] && canReach(x + 1, y, threshold)) {
            tmp1 = bfs(threshold, rows, cols, x + 1, y, visited);
        }
        if (y + 1 < cols && !visited[x][y + 1] && canReach(x, y + 1, threshold)) {
            tmp2 = bfs(threshold, rows, cols, x, y + 1, visited);
        }
        return flag + tmp1 + tmp2;
    }
    private boolean canReach(int i, int j, int threshold) {
        int tmp = 0;
        while (i > 0) {
            tmp += i % 10;
            i /= 10;
        }
        while (j > 0) {
            tmp += j % 10;
            j /= 10;
        }
        return tmp <= threshold;
    }

}
