package LeetCode.Array;
/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] arr, int sum) {
        int n = arr.length;
        int result = arr[0] + arr[1] + arr[n - 1];
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            
            int low = i + 1;
            int high = n - 1;
            
            while (low < high) {
                int temp_sum = arr[low] + arr[high] + arr[i];
                if (temp_sum < sum) {
                    low++;
                }
                else {
                    high--;
                }
                
                if (Math.abs(sum - temp_sum) < Math.abs(sum - result)) {
                    result = temp_sum;
                }
            }
        }
        return result;
    }
}
