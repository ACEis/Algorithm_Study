package cn.edu.cqu.nowcoder;

public class Offer65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k){
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[index] == true || matrix[index] != str[k]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        k++;
        flag[index] = true;
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
