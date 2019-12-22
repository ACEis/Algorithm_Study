package cn.edu.cqu.nowcoder;

public class Offer11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >>> 1));
    }
}
