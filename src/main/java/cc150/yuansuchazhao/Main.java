package cc150.yuansuchazhao;

/**
 * Created by vino on 2017/6/29.
 *
 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，
 需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。
 测试样例：
 [6,1,2,3,4,5],6,6
 返回：0
 */
public class Main {

    public static void main(String[] args) {
        int[] data = {40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
        System.out.println(new Main().findElement(data, 108, 14));
    }

    public int findElement(int[] A, int n, int x) {
        // write code here
        int move = 0;
        int low = 0;
        int high = n - 1;
        int max = A[0];
        int maxIndex = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid + 1]) {
                if (A[mid + 1] > max) {
                    max = A[mid] + 1;
                    maxIndex = mid + 1;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                    low = maxIndex;
                }

            }
            else {
                move = n - mid - 1;
                break;
            }
        }
        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = translate((low + high) / 2, n, move);
            if (A[mid] > x)
                high = recover(mid, n, move) - 1;
            else if (A[mid] < x)
                low = recover(mid, n, move) + 1;
            else //find the target
                return mid;
        }
        return -1;
    }

    private int translate(int i, int n, int move) {
        if (i < move)
            return n - move + i;
        return i - move;
    }

    private int recover(int i, int n, int move) {
        if (n - i > move)
            return i + move;
        return move - n + i;
    }
}
