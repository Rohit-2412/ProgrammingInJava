package LeetCode.Dynamic_Programming;

import java.util.List;

/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
public class Triangle {
    public static Integer[][] dp;
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        dp = new Integer[row][col];
        return minimumPath(triangle, 0, 0);
    }
    
    public static int minimumPath(List<List<Integer>> triangle, int idx, int row) {
        // row out of bound then 0
        if (row >= triangle.size()) {
            return 0;
        }
        // idx out of bound then 0
        if (idx >= triangle.get(idx).size()) {
            return 0;
        }
        
        if (dp[row][idx] == null) {
            int curr = triangle.get(row).get(idx);
            // adding next row's adjacent element
            int sum1 = curr + minimumPath(triangle, idx + 1, row + 1);
            // adding next row's same idx index
            int sum2 = curr + minimumPath(triangle, idx, row + 1);
            // storing minimum sum
            dp[row][idx] = Math.min(sum1, sum2);
        }
        return dp[row][idx];
    }
}
