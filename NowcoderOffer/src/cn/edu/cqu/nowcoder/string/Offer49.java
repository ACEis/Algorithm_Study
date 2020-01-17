package cn.edu.cqu.nowcoder.string;

/**
 *
 */
public class Offer49 {
    public int StrToInt(String str) {
        if ("-2147483648".equals(str)) {
            return -2147483648;
        }
        if (str.startsWith("+")) {
            return pureNum(str.substring(1));
        } else if(str.startsWith("-")) {
            return 0 - pureNum(str.substring(1));
        }
        return pureNum(str);
    }

    private int pureNum(String string) {
        long sum = 0;
        for (int i = 0; i < string.length(); i++) {
            int curr = string.charAt(i) - '0';
            if (curr > 9 || curr < 0) {
                return 0;
            }
            sum += Math.pow(10, string.length() - i - 1) * curr;
        }
        if (Math.abs(sum) > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)sum;
    }
}
