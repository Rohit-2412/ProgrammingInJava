package DSA.String;

import java.util.HashMap;
import java.util.Map;

/*
Smallest window in a string containing all the characters of another string
Medium Accuracy: 42.59% Submissions: 46057 Points: 4
Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including
duplicates) of the string P.  Return "-1" in case there is no such window present. In case there are multiple such
windows of same length, return the one with the least starting index.

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output:
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Example 2:

Input:
S = "zoomlazapzo"
P = "oza"
Output:
apzo
Explanation: "apzo" is the smallest
substring in which "oza" can be found.
 */
public class MinimumWindow {
    
    public static void main(String[] args) {
        System.out.println(minWindow("mpsbqedzsqyskjqydomdanqfmtqri"
                , "rrbqrnbbzyijnwfnimshbjimbfe"));
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
        if (res.length() < 1) {
            return "-1";
        }
        
        else {
            return res;
        }
    }
}
