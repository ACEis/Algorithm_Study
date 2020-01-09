package cn.edu.cqu.nowcoder.sort;

import java.util.ArrayList;

/**
 * 和为S的链各个数字
 */
public class Offer42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int currSum = array[low] + array[high];
            if (currSum == sum) {
                list.add(array[low]);
                list.add(array[high]);
                return list;
            } else if (currSum > sum) {
                high--;
            }else {
                low++;
            }
        }
        return list;
    }
}
