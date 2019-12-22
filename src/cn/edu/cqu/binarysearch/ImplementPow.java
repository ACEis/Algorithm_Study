package cn.edu.cqu.binarysearch;

/**
 * leetocde 50.Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */

public class ImplementPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1/ x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1){
                ans *= current_product;
            }
            current_product = current_product * current_product;
        }

        return ans;
    }
}
