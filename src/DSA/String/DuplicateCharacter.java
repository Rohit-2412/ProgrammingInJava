package DSA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateCharacter {
    
    public static void main(String[] args) {
        String s = "aabbccdefghijj";
        System.out.println(duplicates(s));
    }
    
    static List<Character> duplicates(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> copy = new ArrayList<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) >= 2) {
                    if (!copy.contains(c)) copy.add(c);
                }
            }
        }
        return copy;
    }
}
