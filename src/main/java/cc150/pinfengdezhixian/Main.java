package cc150.pinfengdezhixian;

import java.util.Arrays;

/**
 * Created by vino on 2017/6/7.
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
 给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
 测试样例：
 [(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)]
 返回：[0.0，0.5]
 */
public class Main {

    public static void main(String[] args) {
        Point[] A = new Point[4];
        A[0] = new Point(0, 0);
        A[1] = new Point(0, 1);
        A[2] = new Point(1, 1);
        A[3] = new Point(1, 0);

        Point[] B = new Point[4];
        B[0] = new Point(1, 0);
        B[1] = new Point(1, 1);
        B[2] = new Point(2, 0);
        B[3] = new Point(2, 1);
        System.out.println(Arrays.toString(new Main().getBipartition(A, B)));
    }
    public double[] getBipartition(Point[] A, Point[] B) {
        // write code here
        Point pa1 = A[0];
        Point pa2 = A[1];
        Point pa3 = A[2];
        Point pa4 = A[3];
        double aX;
        double aY;
        if (pa1.y == pa2.y) {
            aX = (pa1.x + pa2.x + 0.0) / 2;
            aY = (pa1.y + pa3.y + 0.0) / 2;
        }
        else if (pa1.y == pa3.y){
            aX = (pa1.x + pa3.x + 0.0) / 2;
            aY = (pa1.y + pa2.y + 0.0) / 2;
        }
        else {
            aX = (pa1.x + pa4.x + 0.0) / 2;
            aY = (pa1.y + pa3.y + 0.0) / 2;
        }

        Point pb1 = B[0];
        Point pb2 = B[1];
        Point pb3 = B[2];
        Point pb4 = B[3];
        double bX;
        double bY;
        if (pb1.y == pb2.y) {
            bX = (pb1.x + pb2.x + 0.0) / 2;
            bY = (pb1.y + pb3.y + 0.0) / 2;
        }
        else if (pb1.y == pb3.y){
            bX = (pb1.x + pb3.x + 0.0) / 2;
            bY = (pb1.y + pb2.y + 0.0) / 2;
        }
        else {
            bX = (pb1.x + pb4.x + 0.0) / 2;
            bY = (pb1.y + pb3.y + 0.0) / 2;
        }

        double a = (bY - aY) / (bX - aX);
        double b = aY - a * aX;
        return new double[]{a, b};
    }
}
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}