package cc150.erdegeshu;

/**
 * Created by vino on 2017/7/22.
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 给定一个正整数n，请返回0到n的数字中2出现了几次。
 测试样例：
 10
 返回：1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().countNumberOf2s(22));
    }

    public int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        int low = 0;
        int high = 0;
        int cur = 0;
        int flag = 1;
        while(n/flag!=0)
        {
            low = n-(n/flag)*flag;
            cur = (n/flag)%10;
            high = n/(flag*10);
            if(cur == 1 || cur == 0)
                count += high*flag;
            if(cur == 2)
                count += high*flag + low +1;
            if(cur > 2)
                count += (high+1)*flag;
            flag *= 10;
        }
        return count;

//分别计算个位，十位……中2出现的次数，然后求和
//        if (n <= 1) return 0;
//
//        long res = 0, m;
//        for (m = 1;m <= n;m *= 10) {
//            long tmp1 = n / m, tmp2 = n % m;
//
//            res += (tmp1 + 7) / 10 * m + ((tmp1 % 10 == 2) ? (tmp2 + 1) : 0);
//        }
//        return (int)res;
    }
}
