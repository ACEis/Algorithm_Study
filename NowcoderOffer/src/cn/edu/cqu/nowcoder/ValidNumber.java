package cn.edu.cqu.nowcoder;

/**
 * leetcode 65.Valid Number
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 */
public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("-01"));
    }
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }
        int Epos = s.indexOf('e') >= 0 ? s.indexOf('e') : s.indexOf('E');
        if (Epos >= 0) {
            return isNumberWithDot(s.substring(0, Epos)) && isNumberWithOp(s.substring(Epos + 1));
        }
        return isNumberWithDot(s);
    }

    private boolean isNumberWithDot(String s){
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        int DotPos = s.indexOf('.');
        if (DotPos >= 0) {
            if (s.substring(0, DotPos) == null && s.substring(DotPos + 1) == null){
                return false;
            }
            if (s.substring(0, DotPos) == null || s.substring(0, DotPos).length() == 0) {
                return isPureNumber(s.substring(DotPos + 1));
            }
            if (s.substring(DotPos + 1) == null || s.substring(DotPos + 1).length() == 0) {
                return isPureNumber(s.substring(0, DotPos));
            }
            return isPureNumber(s.substring(0, DotPos)) && isPureNumber(s.substring(DotPos + 1));
        }
        return isNumberWithOp(s);
    }

    private boolean isNumberWithOp(String s){
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        return isPureNumber(s);
    }

    private boolean isPureNumber(String s){
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
}
