package cn.edu.cqu.nowcoder.sort;

/**
 * 数字在排序数组中出现的次数
 */
public class Offer37 {
    public static int GetNumberOfK(int [] array , int k) {
        int left = findBound(array, k,false);
        int right = findBound(array, k, true);
        if (left == -1) {
            return 0;
        }
        System.out.println("left:" + left + " right:" + right);
        return right -left + 1;
    }

    private static int findBound(int[] array, int k, boolean isRight) {
        int low = 0;
        int bound = -1;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == k) {
                bound = mid;
            }
            if (array[mid] < k || (array[mid] == k && isRight)) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return bound;
    }
}
