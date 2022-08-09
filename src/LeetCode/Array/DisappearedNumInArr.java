package LeetCode.Array;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
*/

import java.util.*;

public class DisappearedNumInArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7};
        List<Integer> ans = findDisappearedNumbers(arr);
        System.out.println(ans);
    }
    
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNum = new ArrayList<>();
        HashSet<Integer> numbers = new HashSet<>();
        for (int i : nums) {
            numbers.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                missingNum.add(i);
            }
        }
        return missingNum;
    }
}