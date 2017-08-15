package cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vino on 2017/8/15.
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。
 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
 测试样例：
 [[1,2],[3,4],[5,6],[7,8]],4
 返回：4
 */
public class 叠罗汉II {
    public static void main(String[] args) {
        int[][] actors = {{1,2},{3,4},{9,10},{5,6},{7,8}};
        System.out.println(new 叠罗汉II().getHeight(actors, 5));

    }
    public int getHeight(int[][] actors, int n) {
        // write code here

        Arrays.sort(actors, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int[] dp = new int[n];
        dp[0] = actors[0][1];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (actors[i][1] <= dp[index]) {
                dp[++index] = actors[i][1];
            }
            else {
                int position = getPosition(dp, 0, index, actors[i][1]);
                dp[position] = actors[i][1];
            }
        }
        return ++index;
    }
    private int getPosition(int[] dp, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) >> 1;
            if (dp[mid] > target) {
                start = mid + 1;
            }
            else if (dp[mid] < target) {
                end = mid;
            }
            else
                return mid;
        }
        return start;
    }
    /*
    public static int getHeight(int[][] actors, int length) {
        // write code here
        if (actors == null || actors.length == 0
                        || length <= 0)
                    return 0;
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(actors, cmp);
        int[] dp = new int[length];
        int maxLens = 0;
        for (int i = length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < length; j++) {             
                if (actors[i][0] < actors[j][0] &&
                            actors[i][1] < actors[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (maxLens < dp[i]) maxLens = dp[i];
        }
        return maxLens;
    }
     */
}
