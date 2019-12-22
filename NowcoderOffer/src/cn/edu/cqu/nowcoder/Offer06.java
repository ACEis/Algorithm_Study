package cn.edu.cqu.nowcoder;

public class Offer06 {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (array[low] < array[high]) {
                return array[low];
            } else if (array[mid] < array[low]) {
                high = mid;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                int min = array[low];
                for (int i = low; i <= high; i++) {
                    min = Math.min(min, array[i]);
                }
                return min;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3, 1, 3}));
    }
}
