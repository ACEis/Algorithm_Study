package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Offer13 {
    /**
     * 时间复杂度O(n^2),空间复杂度O(1)
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if ((array[i] & 1) != 0){
                int curr = array[i];
                int index = i - 1;
                while (index >= 0 && (array[index] & 1) == 0) {
                    array[index + 1] = array[index];
                    index--;
                }
                array[index + 1] = curr;
            }
        }
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param array
     */
    public void reOrderArray(int [] array) {
        List<Integer> listOdd = new ArrayList<>();
        List<Integer> listEven = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                listOdd.add(array[i]);
            }else {
                listEven.add(array[i]);
            }
        }
        for (int i = 0; i < listOdd.size(); i++) {
            array[i] = listOdd.get(i);
        }
        for (int i = 0; i < listEven.size(); i++) {
            array[i + listOdd.size()] = listEven.get(i);
        }
    }
}
