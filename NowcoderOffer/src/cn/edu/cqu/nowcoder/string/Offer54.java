package cn.edu.cqu.nowcoder.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符流中第一个不重复的字符
 */
public class Offer54 {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.replace(ch, (int) map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
