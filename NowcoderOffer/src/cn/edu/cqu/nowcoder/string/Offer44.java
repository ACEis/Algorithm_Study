package cn.edu.cqu.nowcoder.string;

public class Offer44 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverseCharArray(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverseCharArray(chars, blank + 1, chars.length - 1);
        reverseCharArray(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverseCharArray(char[] chars, int start, int end) {
        int len = end - start + 1;
        char[] copy = new char[len];
        for (int i = 0; i < len; i++) {
            copy[i] = chars[i + start];
        }
        for (int i = 0; i < len; i++) {
            chars[i + start] = copy[len - i - 1];
        }
    }
}
