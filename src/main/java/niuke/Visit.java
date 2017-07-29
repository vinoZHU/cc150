package niuke;

/**
 * Created by vino on 2017/7/28.
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 测试样例：
 [[0,1,0],[2,0,0]],2,3
 返回：2
 */
public class Visit {

    public static void main(String[] args) {
        int[][] map = {{0,1,0}, {2,0,0}};
        System.out.println(new Visit().countPath(map, 2, 3));
    }

    public int countPath(int[][] map, int n, int m) {
        // write code here
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                }
                if (map[i][j] == 2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if (x1 == x2 && y1 == y2)
            return 1;
        int direction1 = (x1 > x2) ? -1 : 1;
        int direction2 = (y1 > y2) ? -1 : 1;


        int[][] dp = new int[n][m];

        for (int i = x1; Math.abs(i - x2) >= 0 && i >= 0 && i < n; i += direction1) {
            for (int j = y1; Math.abs(j - y2) >= 0 && j >= 0 && j < m; j += direction2) {
                if (i == x1 || j == y1) {
                    if (map[i][j] != -1) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = 0;
                    }
                }
                else {
                    dp[i][j] = dp[i - direction1][j] + dp[i][j - direction2];
                }
            }
        }
        return dp[x2][y2];
    }
}
