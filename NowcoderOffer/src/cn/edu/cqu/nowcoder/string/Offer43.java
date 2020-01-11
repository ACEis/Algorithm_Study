package cn.edu.cqu.nowcoder.string;

/**
 * 左旋转字符串
 */
public class Offer43 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int count = n % str.length();
        String s = leftRotateStringHelper(str, 0, count - 1)
                + leftRotateStringHelper(str, count, str.length() - 1);
        return leftRotateStringHelper(s, 0, s.length() - 1);

    }

    private String leftRotateStringHelper(String str, int start, int end) {
        char[] c = new char[end - start + 1];
        for (int i = 0; i < end - start + 1; i++) {
            c[i] = str.charAt(end - i);
        }
        return String.valueOf(c);
    }
}
