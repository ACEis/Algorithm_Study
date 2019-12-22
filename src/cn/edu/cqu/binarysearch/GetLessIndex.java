package cn.edu.cqu.binarysearch;

import java.util.Scanner;

public class GetLessIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(getLessIndex(a));
    }

    public static int getLessIndex(int[] a){
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        if (len == 1) return 0;
        if (a[0] < a[1]){
            return 0;
        }
        if (a[len - 2] > a[len -1]){
            return len -1;
        }
        int low = 0;
        int high = len - 1;
        while (high > low){
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]){
                return mid;
            }else if (a[mid] > a[mid - 1]){
                high = mid;
            }else {
                low = mid;
            }
        }
        return -1;
    }
}
