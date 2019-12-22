package cn.edu.cqu.dynamicprogramming;
/**
 * arr	可用面值量，张数无限制
 * aim	需要的零钱数
 * @author Ad
 *
 */

public class ForCorrentChange {
	public static void main(String[] args) {
		int[] arr = {1,2,5};
		//int a = coins1(arr, 1);
		int a1 = coin3(arr, 11);
		System.out.println("结果为	"+ a1);
	}
	
	//暴力法
	public static int coins1(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		
		return process1(arr, 0, aim);
	}
	
	public static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if(index == arr.length) {
			return aim == 0 ? 1 : 0;
		}
		for(int i = 0; i * arr[index] <= aim; i++) {
			res += process1(arr, index + 1, aim - arr[index] * i);	
		}
		return res;
	}
	
	//记忆搜索法
	public static int coins2(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		
		int s = process2(arr, 0, aim, map);
		for(int i = 0; i < arr.length + 1; i++) {
			for(int j = 0; j < aim + 1; j++)
				System.out.print(map[i][j] + "\t");
			System.out.println();
		}
		return s;
	}
	
	public static int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if(index == arr.length) {
			res = aim == 0 ? 1 : 0;
		}else {
			int mapValue = 0;
			for(int i = 0; i * arr[index] <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if(mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				}else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;	
	}
	
	//动态规划---二维数组
	public static int coin3(int[] coins, int amount) {
		int[][] map = new int[coins.length][amount + 1];
		for(int i = 0; i < coins.length; i++) {
			map[i][0] = 1;
		}
		for(int j = 0; j * coins[0] <= amount; j++) {
			map[0][j * coins[0]] = 1;
		}
		for(int i = 1; i < coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				map[i][j] = map[i - 1][j] + (j - coins[i] >= 0 ? map[i][(j - coins[i])] : 0);
			}
		}
		return map[coins.length - 1][amount];
	}
	
	//动态规划---一维数组
	public static int coin4(int[] arr, int aim) {
		int[] map = new int[aim + 1];
		map[0] = 1;
		for(int change : arr) {
			for(int i = 0; i + change <= aim; i++) {
				map[i + change] += map[i];
			}
		}
		return map[aim];
	}
	
}
