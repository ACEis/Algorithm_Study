package cn.edu.cqu.stringalgorithm;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String s){
        String str = reverseStr(s, 0, s.length() - 1);
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(str.charAt(i) == ' ' && left < i){
                str = reverseStr(str, left, i - 1);
                left = i + 1;
            }
        }
        str = reverseStr(str, left, s.length() - 1);
        return str;
    }

    public static  String reverseStr(String s, int low, int high){
        StringBuffer sb = new StringBuffer(s);
        int i = low;
        int j = high;
        while(i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
}
