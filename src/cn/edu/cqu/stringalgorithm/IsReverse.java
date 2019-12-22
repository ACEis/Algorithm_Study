package cn.edu.cqu.stringalgorithm;

/**
 * 一个字符串是否为另一个字符串将某部分前移形成的
 */
public class IsReverse {
    public static void main(String[] args) {
        System.out.println(isReverse("abcdefg", "efgabcd"));
    }

    public static boolean isReverse(String s, String t){
        return KMP(s + s, t);
    }

    @SuppressWarnings("all")
    public static boolean KMP(String s, String t){
        int i = 0;
        int j = 0;
        int[] next = getNext(t);
        while(i < s.length() && j < t.length()){
            if(j == -1 || s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == t.length()){
            return true;
        }
        return false;
    }

    @SuppressWarnings("all")
    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < s.length() - 1){
            if(j == -1 || s.charAt(i) == s.charAt(j)){
                next[++i] = ++j;
            }else{
                j = next[j];
            }
        }
        return next;
    }
}
