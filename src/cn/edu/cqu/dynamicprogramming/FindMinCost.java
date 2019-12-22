package cn.edu.cqu.dynamicprogramming;

public class FindMinCost {
	public static void main(String[] args) {
		System.out.println(findMinCost("abc", 3, "adc", 3, 5, 3, 100));
	}
	
	public static int findMinCost(String A, int n, String B, int m, int ic, int dc, int rc) {
		int res = 0;
		//map[i][j]表示将str1[0~i-1]替换为str2[0~j-1]的最小代价
		int[][] map = new int[n + 1][m + 1];
		for(int i = 0; i <= n; i++) {
			map[i][0] = dc * i;
		}
		for(int i = 0; i <= m; i++) {
			map[0][i] = ic * i;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				int min = Math.min(map[i - 1][j] + dc, map[i][j - 1] + ic);
				if(A.charAt(i - 1) == B.charAt(j - 1)) {
					min = Math.min(min, map[i - 1][j - 1]);
				}else {
					min = Math.min(min, map[i - 1][j - 1] + rc);
				}
				map[i][j] = min;
			}
		}
		
		
		return map[n][m];
	}
}
