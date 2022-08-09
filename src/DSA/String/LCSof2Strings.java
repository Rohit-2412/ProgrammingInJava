package DSA.String;

import java.util.Arrays;

public class LCSof2Strings {
    
    public static void main(String[] args) {
        System.out.println(LCS("abcdefghij", "aabbccddee"));
    }
    
    /*
    System.out.println(LCS("abcdefghij", "aabbccddee"));
    
    DP Grid will become like this :
        a   b  c  d  e  f  g  h  i  j
  a  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
  a  [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
  b  [0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2]
  b  [0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3]
  c  [0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4]
  c  [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
  d  [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
  d  [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
  e  [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
  e  [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
     [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
     */
    static int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];

//         first column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        // first row
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[n][m];
    }
}
