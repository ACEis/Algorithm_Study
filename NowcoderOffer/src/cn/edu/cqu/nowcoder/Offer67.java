package cn.edu.cqu.nowcoder;

public class Offer67 {
    public static int cutRope(int target) {
        if (target < 2){
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] products = new int[target + 1];
        for (int i = 0; i < 4; i++) {
            products[i] = Math.max(i, cutRope(i));
        }
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= target / 2; j++) {
                products[i] = Math.max(products[i], products[j] * products[target - j]);
            }
        }
        return products[target];
    }

    public static void main(String[] args) {
        cutRope(4);
    }
}
