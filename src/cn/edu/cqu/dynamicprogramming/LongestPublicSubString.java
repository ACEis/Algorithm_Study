package cn.edu.cqu.dynamicprogramming;

public class LongestPublicSubString {
	public static void main(String[] args) {
		System.out.println(findLCS("1A2C",4,"B1",2));
	}
	
	public static int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == B.charAt(0)){
                for(int j = i; j < n; j++){
                    map[j][0] = 1;
                }
                break;
            }
            map[i][0] = 0;
        }
        for(int i = 0; i < m; i++){
            if(A.charAt(0) == B.charAt(i)){
                for(int j = i; j < m; j++){
                    map[0][j] = 1;
                }
                break;
            }
            map[0][i] = 0;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                int max = Math.max(map[i - 1][j], map[i][j - 1]);
                if(A.charAt(i) == B.charAt(j))
                    max = Math.max(max, map[i - 1][j - 1] + 1);
                map[i][j] = max;
            }
        }
        return map[n - 1][m - 1];
    }
	
//	public static int findLCS(String A, int n, String B, int m) {
//        // write code here
//        int[][] map = new int[n][m];
//        char[] ac = A.toCharArray();
//        char[] bc = B.toCharArray();
//        for(int i = 0; i < m; i++){
//            if(ac[0] == bc[i]){
//                for(int j = i; j < m; j++){
//                    map[0][j] = 1;
//                }
//                break;
//            }
//            map[0][i] = 0;
//        }
//        for(int i = 0; i < n; i++){
//            if(ac[i] == bc[0]){
//                for(int j = i; j < n; j++){
//                    map[j][0] = 1;
//                }
//                break;
//            }
//            map[i][0] = 0;
//        }
//
//        for(int i = 1; i < n; i++){
//            for(int j = 1; j < m; j++){
//                int max = Math.max(map[i - 1][j], map[i][j - 1]);
//                if(ac[i] == bc[j])
//                    max = Math.max(max, map[i - 1][j - 1] + 1);
//                map[i][j] = max;
//            }
//        }
//        return map[n - 1][m - 1];
//    }
}
