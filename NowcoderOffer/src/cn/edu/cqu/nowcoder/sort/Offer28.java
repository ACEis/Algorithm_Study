package cn.edu.cqu.nowcoder.sort;

/**
 * 数组中出现次数超过一半的数字
 */
public class Offer28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1;
        int c = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == c) {
                count++;
            }else {
                count--;
            }
            if (count == 0) {
                c = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return c;
        }
        return 0;
    }
}
