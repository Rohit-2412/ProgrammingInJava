package DSA.String;

/*
Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct)
 which could be formed from the string str.
Note: You have to return the answer module 1e9 + 7;
 */

public class PalindromicSubsequence {
    
    public static void main(String[] args) {
        System.out.println(countPalindrome("abcba"));
    }
    
    static long countPalindrome(String str) {
        int n = str.length();
        int count = str.length();
        long val = (long) (1e9 + 7);
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        
        return count % val;
        
    }
    
}
