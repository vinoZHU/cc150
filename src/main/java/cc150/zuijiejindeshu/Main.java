package cc150.zuijiejindeshu;

import java.util.Arrays;

/**
 * Created by vino on 2017/6/6.
 *
 根据《程序员面试金典》上的位算数解法写的。
 c01是拖尾0的个数，c01是拖尾0左方全为1的位的个数。p位除了拖尾0之外最最右边的0的位，p=c01+c11。x后一个数求取：
 1.将位p置1；
 2.将位0到p位清零；
 3.将位0到c11-1位置1.
  
 c1为拖尾1的个数，c0位拖尾1右方全为0的位的个数，p=c0+c1.则x前面一个数的求取步骤：
 1.将p位清零。
 2.将位p右边所有的位置1.
 3.将位0到位c0-1清零。
 具体到位上怎么操作，可以翻来数或下电子版来看看。我只是提供途径，公式不好打出来。

 也可以蛮力，一个数字一个数字尝试
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main().getCloseNumber(76351)));
    }

    public int[] getCloseNumber(int x) {
        // write code here
        int[] a = new int[2];
        getNext(x, a);
        getPrev(x, a);
        return a;
    }

    void getPrev(int x, int[] a) {
        int k = x, p = 0, c0 = 0;

    // 求拖尾1（1后面跟0）的位置p
        for (; k != 0; k >>= 1, p++) {
            if ((k & 1) == 0)
                c0++;
            else if (c0 > 0)
            break;
        }
    // 将p位置0
        k = 1 << p;
        x &= ~k;
        // 将p后所有位置0
        x &= ~(k - 1);
        // 补全c0-1个0放在最后，其它为1
        x |= (k - 1) & ~((1 << (c0 - 1)) - 1);
        a[0] = x;
    }

    void getNext(int x, int[] a) {
        int k = x, p = 0, c1 = 0; // c1代表1的个数

        // 求不拖尾0（0后面跟1）的位置p
        for (; k != 0; k >>= 1, p++) {
            if ((k & 1) == 1)
                c1++;
            else if (c1 > 0)
                break;
        }
        // 将p位置1
        k = 1 << p;
        x |= k;
        // 将p后所有位置0
        x &= ~(k - 1);
        // 补全c1-1个1
        x |= (1 << c1 - 1) - 1;
        a[1] = x;
    }
}
