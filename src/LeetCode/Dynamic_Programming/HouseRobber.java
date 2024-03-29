package LeetCode.Dynamic_Programming;
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
// stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
// connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
// can rob tonight without alerting the police.

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 7, 4};
        System.out.println(rob(arr));
    }
    
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // bottom up approach
        for (int i = 2; i < nums.length; i++) {
            // either we are robbing 1st & 3rd house or 2nd house (for 3 houses)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}
