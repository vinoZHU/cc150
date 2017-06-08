package cc150.dikegeshu;

import java.util.LinkedList;

/**
 * Created by vino on 2017/6/7.
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 给定一个数int k，请返回第k个数。保证k小于等于100。
 测试样例：
 3
 返回：7

 链接：https://www.nowcoder.com/questionTerminal/d5e776441a6e41ae9f9859413bdc1eca
 来源：牛客网

 使用三个队列q3、q5、q7，最初存放3、5、7；


 */
public class Main {

    public int findKth(int k) {
        LinkedList<Integer> q3 = new LinkedList<>();
        LinkedList<Integer> q5 = new LinkedList<>();
        LinkedList<Integer> q7 = new LinkedList<>();
        q3.offer(3);
        q5.offer(5);
        q7.offer(7);

        int index = 1;
        int min = 0;
        while( index<=k ){
            min = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
            if ( min==q3.peek() ) {
                q3.poll();
                q3.offer(min*3);
                q5.offer(min*5);
                q7.offer(min*7);
            }
            if ( min==q5.peek() ) {
                q5.poll();
                q5.offer(min*5);
                q7.offer(min*7);
            }
            if ( min==q7.peek() ) {
                q7.poll();
                q7.offer(min*7);
            }
            index++;
        }

        return min;
    }
}
