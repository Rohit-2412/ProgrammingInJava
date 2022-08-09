package DSA.String;

import java.util.HashMap;

// Program to check if given strings S1 and S2. Gives resultant string S3.
public class ValidShuffle {
    
    public static void main(String[] args) {
        
        String s1 = "abc", s2 = "123", s3 = "abc123";
        System.out.println(shuffle(s1, s2, s3));
    }
    
    static boolean shuffle(String s1, String s2, String result) {
//        Approach: First we will put all the elements present in string S3 to a HashMap
//        Then we will traverse the string S1 and S2 and decrement the number of counts in the map.
//        If count becomes negative, then we will return false else we will return true.
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : result.toCharArray()) {
            map.putIfAbsent(ch, 0);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.clear();
            }
            else {
                return false;
            }
        }
        
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.clear();
            }
            else {
                return false;
            }
        }
        System.out.println(map.size());
        System.out.println(map.values());
        return true;
    }
}
