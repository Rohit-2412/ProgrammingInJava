package DSA.String;

/*
Given two strings s and t. Return the minimum number of operations required to convert s to t.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
 */

public class Distance {
    
    public static void main(String[] args) {
        System.out.println(findDistance("abcde", "eacb"));
    }

//    another DP Approach
    
    static int findDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];
        
    }

/*
    static int editDistance(String s, String t) {
        //memoization
        int[][] memo = new int[s.length() + 1][t.length() + 1];
        return memo(s, t, memo);
    }
    
    //memoization
    public static int memo(String s, String t, int[][] arr) {
        if (s.length() == 0) {
            return t.length();
        }
        
        if (t.length() == 0) {
            return s.length();
        }
        
        if (arr[s.length()][t.length()] > 0) {
            return arr[s.length()][t.length()];
        }
        
        if (s.charAt(0) == t.charAt(0)) {
            arr[s.length()][t.length()] = memo(s.substring(1), t.substring(1), arr);
            return memo(s.substring(1), t.substring(1), arr);
        }
        
        else {
            int op1 = memo(s.substring(1), t.substring(1), arr);
            int op2 = memo(s, t.substring(1), arr);
            int op3 = memo(s.substring(1), t, arr);
            
            int optimal_task = 1 + Math.min(op1, Math.min(op2, op3));
            arr[s.length()][t.length()] = optimal_task;
            return optimal_task;
        }
        
    }
    
*/

}

