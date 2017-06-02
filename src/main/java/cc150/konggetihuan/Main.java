package cc150.konggetihuan;

/**
 * Created by vino on 2017/6/1.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().replaceSpace("Mr John Smith", 13));
    }

    public String replaceSpace(String iniString, int length) {
        // write code here
        return iniString.replaceAll(" ", "%20");
    }
}
