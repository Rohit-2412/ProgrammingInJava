package DSA.Searching_Sorting;

import java.util.Arrays;

public class MaxSumWithNoAdjacent {
// this problem is similar to House Robber - Leetcode
// make a dp array and start from bottom to up build the solution
    
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(maxSum(arr));
    }
    
    static int maxSum(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        int n = arr.length;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
