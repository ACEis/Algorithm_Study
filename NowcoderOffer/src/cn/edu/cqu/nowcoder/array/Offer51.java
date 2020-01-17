package cn.edu.cqu.nowcoder.array;

/**
 * 构建乘积数组
 */
public class Offer51 {
    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = n - 1; i > 0; i--) {
            temp *= A[i];
            B[i - 1] *= temp;
        }
        return B;
    }
}
