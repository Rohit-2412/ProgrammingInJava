package DSA.String;

/*

Rearrange characters in a string such that no two adjacent are same

Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent
characters are same.
Note : It may be assumed that the string has only lowercase English alphabets.
Examples:


Input: aaabc
Output: abaca

Input: aaabb
Output: ababa

Input: aa
Output: Not Possible

Input: aaaabc
Output: Not Possible
 */

public class RearrangeCharacters {
    
    public static void main(String[] args) {
        System.out.println(reArrange("aaaaabcbcdddddda"));
    }
    
    static char getMaxCount(int[] count) {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char) ('a' + i);
            }
        }
        return ch;
    }
    
    static String reArrange(String s) {
        int n = s.length();
        int[] count = new int[26];
        
        // getting count of characters
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        char ch_max = getMaxCount(count); // getting character of maximum frequency
        int maxCount = count[ch_max - 'a'];
        
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        res.append(" ".repeat(n));
        int idx = 0;
        
        while (maxCount != 0) {
            res.setCharAt(idx, ch_max);
            idx++;
            idx++;
            
            maxCount--;
        }
        count[ch_max - 'a'] = 0;
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                idx = (idx >= n) ? 1 : idx;
                res.setCharAt(idx, (char) ('a' + i));
                idx += 2;
                count[i]--;
            }
        }
        return res.toString();
        
    }
}
