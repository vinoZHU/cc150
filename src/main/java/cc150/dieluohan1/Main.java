package cc150.dieluohan1;


/**
 * Created by vino on 2017/6/30.
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每个人的身高，请编写代码计算通过选择参与游戏的人，我们多能叠多少个人。
 * 注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。
 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
 测试样例：
 [1,6,2,5,3,4],6
 返回：4
 */
public class Main {

    public static void main(String[] args) {
        int[] data = {1092087,253439,1229092,2638575,2592914,1545673,2357912,1464954,1482904,2115048,1039606,3019682,2499687,2603974,235944,2029011,2594318,26817,2530237,2653234,1518368,102504,751515,1273453,252197,2328429,114699,833494,2437962,1897327,2358947,728206,1694538,1111877,2304261,1550585,2795216,1128077,2526780,2408154,1675787,1569084,542965,864374,2005718,2162685,562828,1806478,489256,643066,2684533,2308573,1242746,663914,893865,1350619,920645,706738,2053610,2975455,803894,37303,108282,78804,97230,2172571,1461268,2662562,597858,1434826,1379291,2481759,671296,489579,1997678,1361658,1793206,2500057,2428656,2228999,2758410,1766219,119904,2336578,1806119,1552636,1475687,1859500,773279,882156,286334,2887969,1579820,2178007,1736233,2042787,1545966,1657224,2524335,477841,256167,973209,2432626,564747,1915507,933567,2478598};
        System.out.println(new Main().getHeight(data, 107));
    }

    public int getHeight(int[] men, int n) {
        // write code here

//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 1; i < n; i++) {
//            if (men[i] > men[i - 1])
//                dp[i] = dp[i - 1] + 1;
//            else {
//                int current = i - 1;
//                int max = 0;
//                while (current >= 0) {
//                    if (men[current] < men[i]) {
//                        dp[i] = dp[current] + 1;
//                        break;
//                    }
//                    current--;
//                }
//                if (current == -1)
//                    dp[i] = 1;
//            }
//        }
//        Arrays.sort(dp);
//        return dp[n - 1];

//        int[] dp = new int[n];
//        dp[0] = men[0];
//        int length = 1;
//        for (int i = 1; i < n; i++) {
//            if (men[i] > men[i - 1]) {
//                length++;
//                dp[length - 1] = men[i];
//            }
//            else {
//                int current = i;
//                while (current >= 0) {
//                    if (men[current] < men[i]) {
//                        dp[current + 1] = men[i];
//                        break;
//                    }
//                    current--;
//                }
//            }
//        }
//        return length;
        int len = 1;
        int[] end = new int[n + 1];
        for (int i = 1; i < n; i++)
        {
            int pos = upper_bound(end, 1, len, men[i]); //找到插入位置
            end[pos] = men[i];
            if (len < pos) //按需要更新LIS长度
                len = pos;
        }
        return len;
    }

    /**
     *
     * @param arr
     * @param s start
     * @param e end
     * @param key
     * @return
     */
    int upper_bound(int arr[], int s, int e, int key)
    {
        int mid;
        if (arr[e] <= key)
            return e + 1;
        while (s < e)
        {
            mid = (s + e) / 2;
            if (arr[mid] <= key)
                s = mid + 1;
            else
                e = mid;
        }
        return s;
    }

}
