package cn.edu.cqu.stringalgorithm;

/**
 * 空格替换为%20
 */

public class SpaceToSpecialChar {
    public static void main(String[] args) {
        System.out.println(spaceToSpecialChar("a b c"));
    }

    public static String spaceToSpecialChar(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                count++;
            }
        }
        char[] array = new char[s.length() + 2 * count];
        int curr = array.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                array[curr--] = '0';
                array[curr--] = '2';
                array[curr--] = '%';
            }else{
                array[curr--] = s.charAt(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
