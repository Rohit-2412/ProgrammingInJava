package DSA.String;

/*
Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given
 string. The two identified subsequences A and B can use the same ith character from string str if and only if that
 ith character has different indices in A and B.
 */
public class LongestRecurringSubsequence {
    public static void main(String[] args) {
        String s = "apnapnaapna";
        System.out.println(lcs(s));
    }
    
    static int lcs(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1]; // Initializing 2D DP table.
        // Filling leftmost column with zero value.
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;
        
        // Filling uppermost row with zero value.
        for (int j = 0; j < n + 1; j++)
            dp[0][j] = 0;
        
        // Comparing the whole string character by character with itself.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(j - 1) == str.charAt(i - 1) && (i != j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
    
}
