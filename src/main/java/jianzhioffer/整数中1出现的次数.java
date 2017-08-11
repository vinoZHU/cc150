package jianzhioffer;

/**
 * Created by vino on 2017/8/11.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class 整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {

        int times = 0,current, addOne = 0,powerOfTen = 0,n2 = n;

        while (n > 0){
            current = n % 10;
            n /= 10;
            if (current > 1) {
                addOne = 1;
            }
            else if (current == 1){
                times += (n2 % Math.pow(10,powerOfTen)) + 1;
            }
            times += (n + addOne) * Math.pow(10, powerOfTen);
            powerOfTen++;
            addOne = 0;
        }

        return times;
    }
}
