package cn.edu.cqu.nowcoder;

public class Offer12 {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double res = 1.0;
        if (exponent < 0) {
            base = 1 / base;
            exponent = 0 - exponent;
        }
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
}
