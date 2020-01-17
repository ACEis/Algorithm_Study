package cn.edu.cqu.nowcoder.bitoperation;

/**
 * 求1+2+3+...+n
 */
public class Offer47 {
    public int Sum_Solution(int n) {
        int res = n;
        boolean flag = ((n == 0) || (res += Sum_Solution(n - 1)) > 0);
        return res;
    }
}
