package cn.edu.cqu.sortalgorithm;

/**
 * 荷兰国旗问题：
 * 有0,1,2三种数字的数组，使其有序
 */
public class Partition3Num {
    public static void main(String[] args) {
        int[] a = {0, 0, 2, 2,  0, 2, 0};
        partition(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] partition(int[] array){
        int len  = array.length;
        if(len < 2) {
            return array;
        }
        int firstIndex = 0;
        int thirdIndex = len - 1;
        int i = 0;
        while(i < thirdIndex){
            if(array[i] == 0) {
                swap(array, i, firstIndex++);
            }else if(array[i] == 2) {
                swap(array, i, thirdIndex--);
            }
            if(array[i] == 1 || i <= firstIndex) {
                i++;
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
