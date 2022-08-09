// 16-07-2022 12:53 July

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Maximum sum of absolute difference of any permutation

Difficulty Level : Easy
Last Updated : 04 Jun, 2022
Given an array, we need to find the maximum sum of absolute difference of any permutation of the given array.
Examples:


Input : { 1, 2, 4, 8 }
Output : 18
Explanation : For the given array there are
several sequence possible
like : {2, 1, 4, 8}
       {4, 2, 1, 8} and some more.
Now, the absolute difference of an array sequence will be
like for this array sequence {1, 2, 4, 8}, the absolute
difference sum is
= |1-2| + |2-4| + |4-8| + |8-1|
= 14
For the given array, we get the maximum value for
the sequence {1, 8, 2, 4}
= |1-8| + |8-2| + |2-4| + |4-1|
= 18
 */
public class MaximiseAbsDiff {
    
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maxSumDifference(arr, arr.length));
        System.out.println(maxSum(arr, arr.length));
    }
    
    static int maxSumDifference(Integer[] arr, int n) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length / 2; i++) {
            list.add(arr[i]);
            list.add(arr[n - i - 1]);
        }
        
        if (n % 2 != 0) list.add(n / 2);
        System.out.println(list);
        
        int sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += Math.abs(list.get(i) - list.get(i + 1));
        }
        return sum;
    }
    
    // for circular array
    static long maxSum(Integer[] arr, int n) {
        
        long sum = 0;
        
        Arrays.sort(arr);
        
        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr[i] - arr[n - i - 1]);
        }
        
        
        return sum;
    }
}