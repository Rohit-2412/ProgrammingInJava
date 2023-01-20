package LeetCode.Array;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
non-decreasing order.

        Example 1:

        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].
        Example 2:

        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]
*/

import java.util.PriorityQueue;

import static java.lang.System.out;


public class SquareOfSortedArr {
    public static void main(String[] args) {
//        int[] arr = {-7, -5, -2, 0, 1, 2, 4, 7, 9, 10};
        int[] arr = {-7, -3, 2, 3, 11};
//        int[] b = sortedSquares(arr);
        int[] b = sortedSq(arr);
        for (int i : b) {
            out.print(i);
            out.print(" ");
        }
    }
    
    // method 1
    public static int[] sortedSquares(int[] num) {
        int[] squares = new int[num.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(num.length);
        for (int j : num) {
            int temp = Math.abs(j);
            pq.add(temp * temp);
        }
        
        for (int i = 0; i < num.length; i++) squares[i] = pq.poll();
        return squares;
    }
    
    // method 2
    // using 2 pointers
    public static int[] sortedSq(int[] arr) {
        int l = 0, r = arr.length - 1;
        int[] ans = new int[arr.length];
        int idx = arr.length - 1;
        while (l <= r) {
            if (Math.abs(arr[l]) > Math.abs(arr[r])) {
                ans[idx] = arr[l] * arr[l];
                l++;
                idx--;
            }
            else {
                ans[idx] = arr[r] * arr[r];
                r--;
                idx--;
            }
        }
        return ans;
    }
}
