package DSA.String;

/*
44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
 */
public class WildcardMatching {
    
    Boolean[][] dp;
    
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }
    
    boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return dp[i][j] = true;
        }
        if (j == p.length()) {
            return dp[i][j] = false;
        }
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) == '*') {
                    j++;
                }
                else {
                    return dp[i][j] = false;
                }
            }
            return dp[i][j] = true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (p.charAt(j) != '*' && p.charAt(j) != '?') {
            if (s.charAt(i) == p.charAt(j)) {
                return dp[i][j] = dfs(s, p, i + 1, j + 1);
            }
            else {
                return dp[i][j] = false;
            }
        }
        else if (p.charAt(j) == '*') {
            return dp[i][j] = dfs(s, p, i + 1, j) || dfs(s, p, i + 1, j + 1) || dfs(s, p, i, j + 1);
        }
        else {
            return dp[i][j] = dfs(s, p, i + 1, j + 1);
        }
    }
}
