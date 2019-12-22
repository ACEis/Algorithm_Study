package cn.edu.cqu.sortalgorithm;

public class FindMatrixNumPosition {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 5},
                     {2, 3, 4, 7},
                     {4, 4, 4, 8},
                     {5, 7, 7, 9}};
        System.out.println(findMatrixNumPosition(a, 9));
    }

    public static boolean findMatrixNumPosition(int[][] matrix, int target){
         int width = matrix[0].length - 1;
         int height = matrix.length - 1;
         int currW = width;
         int currH = 0;
         while(currW >= 0 && currH <= height){
             if(matrix[currW][currH] == target){
                 return true;
             }
             if(matrix[currW][currH] > target){
                 currW--;
             }else{
                 currH++;
             }
         }

         return false;
    }
}
