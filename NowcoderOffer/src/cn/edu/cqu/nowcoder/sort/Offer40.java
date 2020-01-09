package cn.edu.cqu.nowcoder.sort;

/**
 * 数组中只出现一次的数字
 */
public class Offer40 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            num1[0] ^= array[i];
        }
        int diffBit = 1;
        for (; diffBit < num1[0]; diffBit <<= 1) {
            if ((diffBit & num1[0]) != 0) {
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            if ((array[i] & diffBit) != 0) {
                num2[0] ^= array[i];
            }
        }
        num1[0] ^= num2[0];
    }
}
