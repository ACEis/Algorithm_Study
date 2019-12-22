package cn.edu.cqu.sortalgorithm;
/**
 * 插入排序：稳定排序，时间复杂度O(n2),空间复杂度O(1)
 * @author Ad
 *
 */


public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1};
		insertionSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void insertionSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		for(int i = 1; i < len; i++) {
			int curr = array[i];
			int index = i - 1;
			while(index >= 0 && curr < array[index]) {
				array[index + 1] = array[index];
				index--;
			}
			array[index + 1] = curr;
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}