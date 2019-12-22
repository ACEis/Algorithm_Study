package cn.edu.cqu.binarysearch;

/**
 * 有一个有序数组arr，其中不含有重复元素，
 * 请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 */

public class FindIndexEqualValue {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6};
        System.out.println(findIndexEqualtoValue(test));
    }

    public static int findIndexEqualtoValue(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        if (high == -1){
            return -1;
        }
        if (nums[low] == low){
            return low;
        }
        int res = -1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < mid){
                low = mid + 1;
            }else if (nums[mid] > mid){
                high = mid - 1;
            }else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}
