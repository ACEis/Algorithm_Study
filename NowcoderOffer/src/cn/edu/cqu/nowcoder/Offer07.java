package cn.edu.cqu.nowcoder;
/**
 * 07-10
 */

import java.util.ArrayList;

public class Offer07 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list  = new ArrayList<Integer>(10);
    }
}
