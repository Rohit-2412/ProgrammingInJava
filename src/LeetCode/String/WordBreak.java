package LeetCode.String;

/*

Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of
dictionary words.

Note: From the dictionary B each word can be taken any number of times and in any order.

 */

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= n && s.startsWith(w, i)) {
                    dp[i] = dp[i + w.length()];
                }
                
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}
