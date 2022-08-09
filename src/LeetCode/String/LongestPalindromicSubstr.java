package LeetCode.String;

public class LongestPalindromicSubstr {
    
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(longestPalindrome(s));
    }
    
    static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) return 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // expanding our circle
            right++; // expanding our circle
        }
        return right - left - 1;
    }
    
    static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return null;
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i); // case of even length string (aabbaa)
            int len2 = expandFromMiddle(s, i, i + 1); // case of odd length string (racecar)
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }
}
