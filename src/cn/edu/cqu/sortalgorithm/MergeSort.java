package cn.edu.cqu.sortalgorithm;
/**
 * 归并排序 稳定排序，时间复杂度O(nlogn),空间复杂度O(n)
 * @author Ad
 *
 */

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3};
		mergeSort(a, 0, 2);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void mergeSort(int[] array, int start, int end) {
		int len = end - start + 1;
		if(array == null || len <= 1) {
			return;
		}
		int mid = start + len / 2;
		mergeSort(array, start, mid - 1);
		mergeSort(array, mid, end);
		int[] copy = new int[len];
		int i = start;
		int j = mid;
		int pos = 0;
		while(i <= mid - 1 && j <= end && pos < len) {
			if(array[i] <= array[j]) {
				copy[pos++] = array[i++];
			}else {
				copy[pos++] = array[j++];
			}
		}
		while(i <= mid - 1) {
			copy[pos++] = array[i++];
		}
		while(j <= end) {
			copy[pos++] = array[j++];
		}
		for(int m = 0; m < len; m++) {
			array[m + start] = copy[m];
		}
		return;
	}
}
