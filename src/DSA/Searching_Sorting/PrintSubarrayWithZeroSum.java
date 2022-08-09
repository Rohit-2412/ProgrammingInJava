package DSA.Searching_Sorting;

import java.util.HashMap;

/*
You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.

Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 sub-arrays are
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 sub-arrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]
 */
public class PrintSubarrayWithZeroSum {
    
    public static void main(String[] args) {
        long[] arr = {0, 0, 0, 1, 1, 2, -2, 0, 0};
        System.out.println(findSubarray(arr, arr.length));
    }
    
    public static long findSubarray(long[] arr, int n) {
        long count = 0;
        long cur_sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cur_sum += arr[i];
            if (cur_sum == 0) count++;
            count += map.getOrDefault(cur_sum, 0L);
            
            map.put(cur_sum, map.getOrDefault(cur_sum, 0L) + 1L);
        }
        
        return count;
    }
}
