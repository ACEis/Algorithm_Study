package cn.edu.cqu.sortalgorithm;
/**
 * 快速排序 不稳定排序，时间复杂度O(nlogn),空间复杂度O(logn)
 * @author Ad
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1, 6 , 8, 7};
		quickSort(a, 0, 7);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void quickSort(int[] array, int start, int end) {
		if(array == null || array.length <= 1 || start >= end) {
			return;
		}
		int len = end - start + 1;
		int pivot = (int)Math.random() * len + start;
		swap(array, pivot, start);
		int i = start;
		int j = end;
		while(i < j) {
			while(array[j] > array[start] && i < j) {
				j--;
			}
			while(array[i] < array[start] && i < j) {
				i++;
			}
			swap(array, i, j);
		}
		swap(array, start, i);
		quickSort(array, start, i - 1);
		quickSort(array, i + 1, end);
	}
	
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
 
}
