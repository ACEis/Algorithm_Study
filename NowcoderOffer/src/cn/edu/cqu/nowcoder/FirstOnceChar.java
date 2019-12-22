package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstOnceChar {
    public static void main(String[] args) {
        Insert('1');
        System.out.println(FirstAppearingOnce());
    }
    static ArrayList<Character> list = new ArrayList<>();
    static HashMap<Character, Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        list.add(ch);
        if (map.containsKey(ch)){
            map.put(ch, map.get(ch) + 1);
        }else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
