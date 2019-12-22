package cn.edu.cqu.binarysearch;

/**
 * 非官方做法
 * leetcode 34. Find First and Last Position of Element in Sorted Array
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 *
 * 找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 */
public class SearchRange2 {
    public static void main(String[] args) {
        int[] a = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(a[0]+" "+ a[1]);
    }

    /*用两个函数分别查找最大最小坐标*/
    public static int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target, true);
        int right = leftBound(nums, target, false);
        return new int[]{left, right};
    }

    private static int leftBound(int[] nums, int target, boolean left){
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target){
                res = mid;
            }
            if (nums[mid] > target || (left && (nums[mid] == target))){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res;
    }
}
