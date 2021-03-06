package niuke;

import java.util.Scanner;

/**
 * Created by vino on 2017/8/13.
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 问:兰博最多可以清理多少个蘑菇?
 注意：每个方格被扫描一次只能清除掉一个蘑菇。
 输入描述:
 第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
 接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
 一个方格可以种无穷个蘑菇.
 输出描述:
 输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇.

 ??? 测试用例本地可以，牛客上不行，超时？超内存？
 */
public class 扫描透镜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] numbers = new int[n + 1][m + 1];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                numbers[x][y]++;
            }
            int max = Integer.MIN_VALUE;
            int firstI = 0;
            int firstJ = 0;
            for (int i = 1; i <= n - 2; i++) {
                for (int j = 1; j <= m - 2; j++) {
                    int tmp = 0;
                    for (int p = i; p < i + 3; p++) {
                        for (int t = j; t < j + 3; t++) {
                            if (numbers[p][t] > 0)
                                tmp++;
                        }
                    }

                    int originMax = max;
                    max = Math.max(max, tmp);
                    if (max > originMax) {
                        firstI = i;
                        firstJ = j;
                    }
                }
            }
            int count = max;
            for (int i = firstI; i < firstI + 3; i++) {
                for (int j = firstJ; j < firstJ + 3; j++) {
                    if (numbers[i][j] > 0) {
                        numbers[i][j]--;
                    }

                }
            }
            max = Integer.MIN_VALUE;
            for (int i = 1; i <= n - 2; i++) {
                for (int j = 1; j <= m - 2; j++) {
                    int tmp = 0;
                    for (int p = i; p < i + 3; p++) {
                        for (int t = j; t < j + 3; t++) {
                            if (numbers[p][t] > 0)
                                tmp++;
                        }
                    }
                    max = Math.max(max, tmp);
                }
            }
            count += max;
            System.out.println(count);
        }


    }
}
