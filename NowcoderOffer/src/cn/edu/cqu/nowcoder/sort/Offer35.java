package cn.edu.cqu.nowcoder.sort;

public class Offer35 {
    final int NUMBER = 1000000007;
    public int InversePairs(int [] array) {
        int[] copy = new int[array.length];
        return inversePairsHelper(array, copy, 0, array.length - 1);
    }

    private int inversePairsHelper(int[] array, int[] copy, int low, int high) {
        if (high - low <= 1) {
            return 0;
        }
        int mid = low + ((high - low) >> 1);
        int left = inversePairsHelper(array, copy, low, mid) % NUMBER;
        int right = inversePairsHelper(array, copy, mid + 1, high) % NUMBER;
        int count = (left + right) % NUMBER;
        int i = low;
        int j = mid + 1;
        int curr = 0;
        while (i <= mid && j <= high) {
            if (array[i] > array[j]) {
                count += mid - i + 1;
                copy[curr++] = array[j++];
                if (count >= NUMBER) {
                    count %= NUMBER;
                }
            }else {
                copy[curr++] = array[i++];
            }
        }
        while (i <= mid) {
            copy[curr++] = array[i++];
        }
        while (j <= high) {
            copy[curr++] = array[j++];
        }
        for (int k = low; k <= high; k++) {
            array[k] = copy[k];
        }
        return count % NUMBER;
    }
}
