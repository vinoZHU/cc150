package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vino on 2017/8/10.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        int n=1,ugly=1;
        Queue<Integer> q2=new LinkedList<Integer>();
        Queue<Integer> q3=new LinkedList<Integer>();
        Queue<Integer> q5=new LinkedList<Integer>();
        q2.add(2);q3.add(3);q5.add(5);
        while(n!=index){
            ugly=Math.min(q2.peek(),Math.min(q3.peek(),q5.peek()));
            if(ugly==q2.peek()){
                q2.add(ugly*2);q3.add(ugly*3);q5.add(ugly*5);q2.poll();
            }
            if(ugly==q3.peek()){
                q3.add(ugly*3);q5.add(ugly*5);q3.poll();
            }
            if(ugly==q5.peek()){
                q5.add(ugly*5);q5.poll();
            }
            n++;
        }

        return ugly;
    }
}
