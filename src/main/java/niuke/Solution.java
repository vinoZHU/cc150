package niuke;

/**小米:懂二进制
 * http://www.nowcoder.com/questionTerminal/ba033b0d1c2f497da1dd04330cc003af
 * Created by vino on 2016/10/12.
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 输入例子:

 1999 2299

 输出例子:

 7
 */
public class Solution {

    public static void main(String[] args){
        countBitDiff(1999,2299);
    }
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {
        String mString = Integer.toBinaryString(m);
        String nString = Integer.toBinaryString(n);
        int mLength = mString.length();
        int nLength = nString.length();
        int count = 0;
        int tmp;
        if(mLength > nLength){
            tmp = mLength - nLength;
            for(int i = nLength - 1; i >= 0; i--){
                if(mString.charAt(i + tmp) != nString.charAt(i)){
                    count++;
                }
            }
            for(int j =0; j < tmp; j++){
                if(mString.charAt(j) == '1'){
                    count++;
                }
            }
        }
        else{
            tmp = nLength - mLength;
            for(int i = mLength - 1; i >= 0; i--){
                if(nString.charAt(i + tmp) != mString.charAt(i)){
                    count++;
                }
            }
            for(int j =0; j < tmp; j++){
                if(nString.charAt(j) == '1'){
                    count++;
                }
            }
        }
        return count;
    }

//    public int countBitDiff(int m, int n) {
//
//        int dif=m^n;//先将二者做异或运算，得到结果；
//        int cnt=0;
//        while(dif!=0){
    //1
//            dif=dif&(dif-1);
//            cnt++;
    //2
    //dif&1取最后一位,判断是否为1,是的话cnt++

//        }             //统计一个整数dif含有多少个1；
//        return cnt;
//    }

}
