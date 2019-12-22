package cn.edu.cqu.nowcoder.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class Offer32 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (o1, o2) -> ("" + o1 + o2).compareTo("" + o2 + o1));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(1) + String.valueOf(2));
    }
}
