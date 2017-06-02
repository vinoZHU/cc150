package cc150.jihezhan;

import java.util.ArrayList;

/**
 * Created by vino on 2017/6/2.
 *
 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
 给定一个操作序列int[][2] ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；
 若为2，则为pop操作，后一个数无意义。请返回一个int[][](C++为vector<vector<int>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class Main {

    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        int num = ope.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> stack = new ArrayList<Integer>(size);
        for (int i = 0; i < num; i++) {
            if (ope[i][0] == 1) {
                stack.add(ope[i][1]);
            } else if (ope[i][0] == 2) {
                if (stack.size() == 0) {
                    stack = result.remove(result.size() - 1);
                }
                stack.remove(stack.size() - 1);
            }
            if (stack.size() == size || i == num - 1) {
                result.add(stack);
                stack = new ArrayList<Integer>(size);
            }

        }
        return result;
    }
}
