package cn.edu.cqu.stringalgorithm;

/**
 * 最长回文子串
 */

public class LongestPanlindromicSubstring {
    public static void main(String[] args) {
        String str = "12#34";
        System.out.println(manacher(str));
    }

    public static int manacher(String str){
        StringBuffer sb = new StringBuffer("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append("#");
        }

        int[] radius = new int[sb.length()];
        int rightestIndex = -1;
        int rightestCenter = -1;
        int max = 0;
        for (int i = 0; i < sb.length(); i++) {
            radius[i] = rightestIndex > i ? Math.min(radius[2 * rightestCenter - i], rightestIndex - i + 1) : 1;
            while(i + radius[i] < sb.length() && i - radius[i] >= 0
                    && sb.charAt(i - radius[i]) == sb.charAt(i + radius[i])){
                    radius[i]++;
            }
            if(i + radius[i] > rightestIndex){
                rightestIndex = i + radius[i] - 1;
                rightestCenter = i;
            }
            max = Math.max(max, radius[i]);
        }
        return max - 1;
    }
}
