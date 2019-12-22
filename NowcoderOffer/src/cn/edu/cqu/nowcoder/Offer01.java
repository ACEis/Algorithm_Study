package cn.edu.cqu.nowcoder;

public class Offer01 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = 0;
        int j = cols - 1;
        while (i >= 0 && i < rows && j >= 0 && j < cols) {
            if (target == array[i][j]){
                return true;
            }
            if (target > array[i][j]){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
