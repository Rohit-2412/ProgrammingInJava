package LeetCode.Array;

import java.util.Arrays;
/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        // sorting based upon first number
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        int counter = 0;
        int[] prev_interval = intervals[0]; // getting first interval
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // if end of previous interval is greater than start of next interval then it is indication of overlapping
            if (prev_interval[1] > interval[0]) // we have found one overlapping
            // increasing the counter and updating the current interval
            {
                counter++;
                if (prev_interval[1] > interval[1]) {
                    prev_interval = interval;
                }
            }
            else {
                prev_interval = interval;
            }
        }
        return counter;
    }
}
