package cn.edu.cqu.sortalgorithm;

import java.util.ArrayList;

/**
 * leetcode 164.maximum-gap
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 */
public class FindMaxDivision {
    public static void main(String[] args) {
        int[] array = {7, 9, 3, 4, 2, 1, 8};
        System.out.println(maximumGap(array));
    }

    public static int maximumGap(int[] array){
        int len = array.length;
        if(len < 2){
            return 0;
        }
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < len; i++) {
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        if(max == min)  return 0;
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int index = putToBucket(array[i], len, min, max);
            if(hasNum[index]){
                maxs[index] = Math.max(maxs[index], array[i]);
                mins[index] = Math.min(mins[index], array[i]);
            }else{
                hasNum[index] = true;
                maxs[index] = array[i];
                mins[index] = array[i];
            }
        }
        int maxDivision = 0;
        int lastMax = maxs[0];
        int i = 0;
        while(i <= len) {
            if(hasNum[i]){
                maxDivision = Math.max(maxDivision, mins[i] - lastMax);
                lastMax = maxs[i];
            }
            i++;
        }
        return maxDivision;
    }

     public static int putToBucket(int num, int len, int min, int max){
        return (int)((num - min) * len / (max - min));
    }
}
