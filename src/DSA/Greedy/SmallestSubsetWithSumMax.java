// 06-08-2022 12:36 August
/*
Smallest subset with sum greater than all other elements

Difficulty Level : Easy
Last Updated : 09 Apr, 2021
Given an array of non-negative integers. Our task is to find minimum number of elements such that their sum should be
 greater than the sum of rest of the elements of the array.
Examples :


Input : arr[] = {3, 1, 7, 1}
Output : 1
Smallest subset is {7}. Sum of
this subset is greater than all
other elements {3, 1, 1}

Input : arr[] = {2, 1, 2}
Output : 2
In this example one element is not
enough. We can pick elements with
values 1, 2 or 2, 2. In any case,
the minimum count is 2.
 */

package DSA.Greedy;

import java.util.Arrays;

public class SmallestSubsetWithSumMax {
    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 1};
        System.out.println(getCount(arr));
    }
    
    static int getCount(int[] arr) {
        int half_sum = 0;
        for (int i : arr)
            half_sum += i;
        
        half_sum /= 2;
        
        Arrays.sort(arr);
        int count = 0;
        int currSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            count++;
            currSum+=arr[i];
            
            if (currSum>half_sum) return count;
        }
        return count;
        
    }
    
}
