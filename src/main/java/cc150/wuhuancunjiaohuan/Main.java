package cc150.wuhuancunjiaohuan;

/**
 * Created by vino on 2017/7/18.
 */
public class Main {

    public static void main(String[] args) {

    }

    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }
}
