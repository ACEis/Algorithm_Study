package cn.edu.cqu.nowcoder.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 字符串的排序
 */
public class Offer27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() != 0) {
            char[] chars = str.toCharArray();
            HashSet<String> set = new HashSet<>();
            permutationHelper(set, chars, 0, chars.length - 1);
            list.addAll(set);
            Collections.sort(list);
        }
        return list;
    }

    private void permutationHelper(HashSet<String> set, char[] chars, int start, int end) {
        if (start == end) {
            set.add(new String(chars));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(chars, start, i);
            permutationHelper(set, chars, start + 1, end);
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
