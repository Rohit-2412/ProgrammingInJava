package LeetCode.Array;

/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
nums[i] < nums[j] < nums[k]. If no such indices exists, return false.



Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */
public class IncreasingTripletSubsequence {
    /*
    In the problem we have to find increasing subsequence of length 3 ,
If we keep track of two number which are in increasing subsequence then whenever the third increasing number is found
 which fullfil the condition of being part of triplet we would return true

So strategy is loop through array and maintain two variables i and j
i will store 1st increasing subsequence number and j will store second subsequence increasing number , as soon as
thirs increasing subsequence number is found we will return true
else after completion of loop we will return false
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= i) {
                i = num;
            }
            else if (num <= j) {
                j = num;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
