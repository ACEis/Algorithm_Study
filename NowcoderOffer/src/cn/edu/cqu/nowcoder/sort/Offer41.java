package cn.edu.cqu.nowcoder.sort;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 */
public class Offer41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum <= 0) {
            return lists;
        }
        int low = 1;
        int high = 1;
        int currSum = 1;
        while (low < sum) {
            if (currSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                lists.add(list);
                low++;
                high = low;
                currSum = low;
            } else if (currSum < sum) {
                high++;
                currSum += high;
            }else {
                low++;
                high = low;
                currSum = low;
            }
        }
        return lists;
    }
}
