package cn.edu.cqu.binarysearch;

/**
 * leetcode 153. Find Minimum in Rotated Sorted Array
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * leetcode 154.Find Minimum in Rotated Sorted Array II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 */

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = low + ((high - low) >> 1);
            if (nums[low] < nums[high]){
                return nums[low];
            }else if (nums[mid] < nums[low]){
                high = mid;
            }else if (nums[mid] > nums[high]){
                low = mid + 1;
            }else {
                int min = nums[low];
                for (int i = low; i <= high; i++) {
                    min = Math.min(nums[i], min);
                }
                return min;
            }
        }
        return nums[low];
    }
}
