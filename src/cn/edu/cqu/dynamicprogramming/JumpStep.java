package cn.edu.cqu.dynamicprogramming;
/**
 * 跳一或者二
 * @author Ad
 *
 */

public class JumpStep {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(jump3(5));
	}
	
	//暴力法
	public static int jump1(int n) {
		if(n <= 1) return 1;
		return jump1(n - 1) + jump1(n - 2);
	}
	
	//动态规划
	public static int jump2(int n) {
		int[] a = new int[n + 1];
		a[0] = 1;
		a[1] = 1;
		for(int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[n];
	}
	
	//动态规划---省空间
	public static int jump3(int n) {
		int a = 1;
		int b = 1;
		for(int i = 2; i <= n; i++) {
			b = a + b;
			a = b - a;
		}
		return b;
	}

}
