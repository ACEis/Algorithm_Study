package cn.edu.cqu.stringalgorithm;
/**
 * 最长无重复子串
 */

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int pre = 0;
        int[] lenOfSubString = new int[s.length()];
        lenOfSubString[0] = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null || map.get(s.charAt(i)) + 1 < pre){
                lenOfSubString[i] = i - pre + 1;
            }else{
                lenOfSubString[i] = i - map.get(s.charAt(i));
            }
            pre = i - lenOfSubString[i] + 1;
            map.put(s.charAt(i), i);
        }
        int max = 0;
        for (int i = 0; i < lenOfSubString.length; i++) {
            max = Math.max(max, lenOfSubString[i]);
        }
        return max;
    }
}
