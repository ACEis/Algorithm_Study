package cn.edu.cqu.sortalgorithm;
/**
 * 选择排序：不稳定排序，时间复杂度O(n2),空间复杂度O(1)
 * @author Ad
 *
 */


public class SelectionSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1};
		selectionSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void selectionSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		for(int i = 0; i < len; i++) {
			int minIndex = i;
			for(int j = i; j < len; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
