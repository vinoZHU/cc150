package cc150.wupanduanmax;

/**
 * Created by vino on 2017/7/18.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().getMin(1, 4));
        System.out.println(new Main().getMax(2, 4));
    }

    public int getMax(int a, int b) {
        b = a - b;//此时b>>31为1则b小于0即a<b,若b>>31为0 则a>b
        a -= b&(b>>31); //若a<b a=a-(a-b),若a>b a=a-0 
        return a;
    }

    public int getMin(int a, int b) {
        b = b - a;//此时b>>31为1则b小于0即a<b,若b>>31为0 则a>b
        a += b&(b>>31); //若a<b a=a-(a-b),若a>b a=a-0 
        return a;
    }
}
