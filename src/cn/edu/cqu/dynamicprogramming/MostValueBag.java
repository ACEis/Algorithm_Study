package cn.edu.cqu.dynamicprogramming;

public class MostValueBag {
	
	public static void main(String[] args) {
		int[] values = {5, 4, 3, 2, 1};
		int[] weights = {2, 1, 1, 1, 1};
		System.out.println(mostValue(values, weights, 5, 1));
	}
	
	public static int mostValue(int[] values, int[] weights, int n, int w) {
		
		int[][] map = new int[n + 1][w + 1];
		for(int currw = 1; currw < w + 1; currw++) {
			if(weights[0] <= currw) {
				for(int j = currw; j <= w; j++) {
					map[1][j] = values[0];
				}
				break;
			}
			map[0][currw] = 0;
		}
		
		
		for(int currn = 2; currn <= n; currn++) {
			for(int currw = 1; currw <= w; currw++) {
				if(currw - weights[currn - 1] >= 0) {
					map[currn][currw] = Math.max(map[currn - 1][currw - weights[currn - 1]] + values[currn - 1], map[currn - 1][currw]);
					
				}else {
					map[currn][currw] = map[currn - 1][currw];
				}
			}
		}
		
		return map[n][w];
	}

}
