package cn.edu.cqu.stringalgorithm;

/**
 * 字符串匹配的KMP算法
 */

public class KMP {
    public static void main(String[] args) {
        System.out.println(search("BBCABCDABABCDABCDABDE", "ABCDABD"));
    }

    @SuppressWarnings("all")
    // 构造 pattern 的最大匹配数表
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < pattern.length() - 1){
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)){
                next[++i] = ++j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    @SuppressWarnings("all")
    public static int search(String text, String pattern) {
        int i = 0;
        int j = 0;
        int[] next = getNext(pattern);
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
}
