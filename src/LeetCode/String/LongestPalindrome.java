package LeetCode.String;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that
can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] char_counts = new int[128];
        for (char c : s.toCharArray())
            char_counts[c]++;
        int ans = 0;
        for (Integer count : char_counts) {
            ans += (count / 2) * 2;
            // if the current count of chars in an odd number than add one to the ans (the middle char in palindrome)
            if (ans % 2 == 0 && count % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}
