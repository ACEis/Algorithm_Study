package cn.edu.cqu.nowcoder;

import java.util.ArrayList;

public class Offer19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up <= down || left <= right) {
            if (up <= down){
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
            }
            if (right >= left) {
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }
            if (down >= up) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
