package cn.edu.cqu.sortalgorithm;
/**
 * 冒泡排序 不稳定排序，时间复杂度O(n2),空间复杂度O(1)
 * @author Ad
 *
 */


public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1};
		bubbleSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void bubbleSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		for(int i = 0; i < len - 1; i++) {
			for(int j = 0; j < len - i - 1; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}
			
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
