package cc150.zhengshuzhuanhua;

/**
 * Created by vino on 2017/6/6.
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
 给定两个整数int A，int B。请返回需要改变的数位个数。
 测试样例：
 10,5
 返回：4
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().calcCost(10 ,5));
    }
    public int calcCost(int A, int B) {
        // write code here
        int count = 0;
        while (A != 0 || B != 0) {
            if ((A & 1) != (B & 1)) {
                count++;
            }
            A >>= 1;
            B >>= 1;
        }
        return count;
    }
}
