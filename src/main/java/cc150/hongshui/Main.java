package cc150.hongshui;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by vino on 2017/6/19.
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
public class Main {

    public static void main(String[] args) {
        int[][] map = {
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,0}
        };
        System.out.println(new Main().floodFill(map, 4, 5));
    }

    public int floodFill(int[][] map, int n, int m) {
        // write code here
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
//        int[][] time = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++)
//                time[i][j] = Integer.MAX_VALUE;
//        }
//        time[0][0] = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int currentX = point.x;
            int currentY = point.y;
            if (currentX == n - 1 && currentY == m - 1)
                return map[currentX][currentY];
            if (currentX > 0 && map[currentX -1][currentY] == 0) {
                map[currentX - 1][currentY] = map[currentX][currentY] + 1;
                queue.add(new Point(currentX - 1, currentY));

            }
            if (currentY > 0 && map[currentX][currentY - 1] == 0) {
                map[currentX][currentY - 1] = map[currentX][currentY] + 1;
                queue.add(new Point(currentX, currentY - 1));
            }
            if (currentX < n - 1 && map[currentX + 1][currentY] == 0) {
                map[currentX + 1][currentY] = map[currentX][currentY] + 1;
                queue.add(new Point(currentX + 1, currentY));
            }
            if (currentY < m - 1 && map[currentX][currentY + 1] == 0) {
                map[currentX][currentY + 1] = map[currentX][currentY] + 1;
                queue.add(new Point(currentX, currentY + 1));
            }
        }
        return map[n - 1][m - 1];
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
