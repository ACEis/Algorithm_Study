package cn.edu.cqu.sortalgorithm;

public class ShortestDisorderSubArray {
    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2, 6, 7};
        int[] b = {1, 2, 4, 6, 5};
        int[] c = {5, 4, 3, 2, 1};
        System.out.println(shortestDisorderSubArray(a));
        System.out.println(shortestDisorderSubArray(b));
        System.out.println(shortestDisorderSubArray(c));
    }

    public static int shortestDisorderSubArray(int[] array){
        int maxIndex = -1;
        int minIndex = array.length;
        int max = array[0];
        int min = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < max){
                maxIndex = i;
            }else{
                max = array[i];
            }
        }
        for (int i = array.length - 1; i > 0; i--) {
            if(array[i] > min){
                minIndex = i;
            }else{
                min = array[i];
            }
        }
        if(maxIndex - minIndex >= 0){
            return maxIndex - minIndex + 1;
        }
        return 0;
    }
}
