package cn.edu.cqu.nowcoder;

public class Offer02 {
    public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int index = str.length() - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(index--, str.charAt(i));
            }else {
                str.setCharAt(index--, '0');
                str.setCharAt(index--, '2');
                str.setCharAt(index--, '%');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }
}
