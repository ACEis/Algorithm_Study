package cn.edu.cqu.nowcoder;

public class Offer66 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        return movingCountHelper(0, 0, rows, cols, flag, threshold);
    }

    private int movingCountHelper(int i, int j, int rows, int cols, boolean[][] flag, int threshold){
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] == true || numSum(i) + numSum(j) > threshold) {
            return 0;
        }
        flag[i][j] = true;
        return movingCountHelper(i + 1, j, rows, cols, flag, threshold) +
                movingCountHelper(i, j + 1, rows, cols, flag, threshold) +
                movingCountHelper(i - 1, j, rows, cols, flag, threshold) +
                movingCountHelper(i, j - 1, rows, cols, flag, threshold) +
                1;
    }

    private int numSum(int i){
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
