package cc150.moshusuoying;

/**
 * Created by vino on 2017/6/8.
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 测试样例：
 [1,2,3,4,5]
 返回：false
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {-1, 2, 3, 4, 5};
        System.out.println(new Main().findMagicIndex(A, A.length));
    }

    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        int l=0,r=n-1,mid = 0;
        while(l<=r)
        {
            mid = (l+r)/2;
            if(A[mid]==mid)
                return true;
            else if(A[mid]<mid)
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}
