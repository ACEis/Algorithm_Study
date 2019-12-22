package cn.edu.cqu.sortalgorithm;
/**
 * 希尔排序 不稳定排序，时间复杂度O(nlogn),空间复杂度O(1)
 * @author Ad
 *
 */

public class ShellSort {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1, 6 , 8, 7};
		shellSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void shellSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int step = array.length >> 2;
		for(int s = step; s > 0; s /= 2) {
			for(int i = 0; i < array.length; i++) {
				int curr = array[i];
				int index = i - s;
				while(index >= 0 && curr < array[index]) {
					array[index + s] = array[index];
					index -= s;
				}
				array[index + s] = curr;
			}
		}
	}

}
