package cn.edu.cqu.binarysearch;

/**
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
public class SearchRange {
    public static void main(String[] args) {

    }

    /*官方解答，用flag实现查找大小数字的不同*/
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int leftIdx = searchLRRange(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target){
            return res;
        }

        res[0] = leftIdx;
        res[1] = searchLRRange(nums, target, false) - 1;

        return res;
    }

    /**
     * 对left = true
     * 返回数组中等于target的第一个坐标（有target）
     * 或者数组中第一个大于target的坐标（无target）
     * 对left = false
     * 由于一定存在target才会进行到这里
     * 所以返回数组中等于target的最右坐标 + 1
     *
     */
    private static int searchLRRange(int[] nums, int target, boolean left){
        int low = 0;
        int high = nums.length;

        while (low < high){
            int mid = low + ((high - low) / 2);
            if (nums[mid] > target || (left && target == nums[mid])){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }
}
