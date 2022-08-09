package DSA.String;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    public static void main(String[] args) {
//        System.out.println(minWindow("adobecodebanc", "abc"));
        
        unique("aabcdabdabb");
    }
    
    static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int count = t.length();
        int val = 0;
        
        String res = "";
        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) continue;
            
            val = map.get(ch);
            if (val > 0) {
                count--; //s = bba, t = ab case, do not need to count 2nd b, but still need to reduce map counts
            }
            map.put(ch, map.get(ch) - 1);
            
            // shrink window
            while (count == 0 && left <= right) { // found
                if (res.isEmpty() || res.length() > (right - left + 1)) {
                    res = s.substring(left, right + 1);
                }
                char lChar = s.charAt(left);
                if (map.containsKey(lChar)) {
                    val = map.get(lChar);
                    if (val == 0) count++; //s = bba, t = ab case
                    map.put(lChar, val + 1);
                }
                left++;
            }
        }
        return res;
    }
    
    static void unique(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : map.keySet()) {
            sb.append(c);
        }
        String t = sb.toString();
        System.out.println(minWindow(s, t));
    }
}
