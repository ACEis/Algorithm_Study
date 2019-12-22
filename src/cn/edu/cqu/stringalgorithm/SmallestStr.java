package cn.edu.cqu.stringalgorithm;

/**
 * 将一个字符串数组排列为字典序最小的字符串
 */

public class SmallestStr {
    public static void main(String[] args) {
        String[] strs = {"b", "ba"};
        System.out.println(smallestString(strs));
    }

    public static String smallestString(String[] strs){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length - i - 1; j++) {
                if((strs[j] + strs[j + 1]).compareTo(strs[j + 1] + strs[j]) > 0){
                    swapstr(strs, j, j + 1);
                }
            }
        }
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void swapstr(String[] strs, int i, int j){
        String s = strs[i];
        strs[i] = strs[j];
        strs[j] = s;
    }
}
