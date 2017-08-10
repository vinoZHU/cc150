package jianzhioffer;

import java.util.HashSet;

/**
 * Created by vino on 2017/8/9.
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class 扑克牌顺子 {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 6, 4};
        System.out.println(new 扑克牌顺子().isContinuous(numbers));
    }
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5)
            return false;
        int kingNum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                kingNum++;
            else {
                if (set.contains(numbers[i]))
                    return false;
                else
                    set.add(numbers[i]);
                max = Math.max(max, numbers[i]);
                min = Math.min(min, numbers[i]);
            }
        }
        if (max - min < 5)
            return true;
        return false;
    }
}
