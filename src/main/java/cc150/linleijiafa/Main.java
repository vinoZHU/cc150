package cc150.linleijiafa;

/**
 * Created by vino on 2017/7/22.
 * 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
 给定两个int A和B。请返回A＋B的值
 测试样例：
 1,2
 返回：3
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().addAB(1, 4));
    }

    public int addAB(int A, int B) {
        // write code here
        int tem=0;//代表进位位
        do{
            tem=A&B;
            A=A^B;
            B=tem<<1;
        }
        while(B!=0);
        return A;
    }
}
