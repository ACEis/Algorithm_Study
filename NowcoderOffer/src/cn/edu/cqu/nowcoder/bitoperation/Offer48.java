package cn.edu.cqu.nowcoder.bitoperation;

import java.util.ArrayList;

/**
 * 不用加减乘除做加法
 */
public class Offer48 {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    /*
    public static int Add(int num1,int num2) {
        int bitTwo = 0;
        int bitOne = 0;
        int currBit = 1;
        int curr1 = 0;
        int curr2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        while (currBit <= (num1 << 1) || currBit <= (num2 << 1)) {
            curr1 = (num1 & currBit) == 0 ? 0 : 1;
            curr2 = (num2 & currBit) == 0 ? 0 : 1;
            bitOne = curr1 ^ curr2 ^ bitTwo;
            bitTwo = (curr1 | curr2) & (curr2 | bitTwo) & (curr1 | bitTwo);
            stringBuffer.append(bitOne);
            currBit <<= 1;
        }
        stringBuffer.reverse();
        int sum = Integer.parseInt(stringBuffer.toString(), 2);
        return sum;
    }
     */
}
