package DSA.String;

/*

Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of
dictionary words.

Note: From the dictionary B each word can be taken any number of times and in any order.

 */

import java.util.ArrayList;

public class WordBreak {
    
    public static int wordBreak(String s, ArrayList<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= n && s.startsWith(w, i)) {
                    dp[i] = dp[i + w.length()];
                }
                
                if (dp[i] == 1) break;
            }
        }
        return dp[0];
    }
    
}
