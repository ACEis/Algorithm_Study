package cn.edu.cqu.sortalgorithm;
/**
 * 堆排序 不稳定排序，时间复杂度O(nlogn),空间复杂度O(logn)
 * @author Ad
 *
 */
public class HeapSort {
	static int len = 0;
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1, 6 , 8, 7, 11, 10, 9};
		heapSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void heapSort(int[] array) {
		len = array.length;
		if(len < 1) {
			return;
		}
		buildMaxHeap(array);
		while(len > 0) {
			swap(array, 0, len - 1);
			len--;
			adjustHeap(array, 0);
		}
		return;
	}
	
	public static void buildMaxHeap(int[] array) {
		for(int i = len / 2 - 1; i >= 0; i--) {
			adjustHeap(array, i);
		}
	}
	
	public static void adjustHeap(int[] array, int i) {
		int maxIndex = i;
		if(i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
			maxIndex = i * 2 + 1;
		}
		if(i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex])
			maxIndex = i * 2 + 2;
		if(maxIndex != i) {
			swap(array, maxIndex, i);
			adjustHeap(array, maxIndex);
		}
	}
	
	
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	

}
