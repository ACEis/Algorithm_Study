package cn.edu.cqu.nowcoder;

/**
 * 整数中1出现的次数
 */
public class Offer31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 0) {
            return 0;
        }
        int i = 1;
        int count = 0;
        while (i <= n) {
            int k = n % (i * 10);
            count += n / (i * 10) * i + Math.min(Math.max(0, k - i + 1), i);
            i *= 10;
        }
        return count;
    }
}
