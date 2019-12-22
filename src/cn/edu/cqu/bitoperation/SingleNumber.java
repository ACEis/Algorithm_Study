package cn.edu.cqu.bitoperation;

/**
 * leetcode 136.single-number
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * leetcode 260. Single Number III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，
 * 其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 */
public class SingleNumber {
    private static int binaryNum(int num, int index){
        return (num >>> index) % 2;
    }
    public static int[] singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Integer.toBinaryString(nums[i]));
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int s = 0;
        for (int i = 0; Math.pow(2, i) <= Math.abs(res); i++){
            if (binaryNum(res, i) != 0){
                s = i;
                break;
            }
        }
        int halfres = 0;
        for (int i = 0; i < nums.length; i++) {
            if (binaryNum(nums[i], s) != 0) {
                halfres ^= nums[i];
            }
        }
        int[] result = new int[2];
        result[0] = halfres;
        result[1] = res ^ halfres;
        return result;
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
