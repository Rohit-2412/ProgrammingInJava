package DSA.Searching_Sorting;

/*
33. Search in Rotated Sorted Array
Medium

13583

871

Add to List

Share
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));
    }
    
    public static int search(int[] arr, int target) {
        if (Binary(arr, target, 0, pivot(arr)) < 0) {
            return (Binary(arr, target, pivot(arr) + 1, arr.length - 1));
            
        }
        else {
            return (Binary(arr, target, 0, pivot(arr)));
        }
    }
    
    static int pivot(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i - 1;
            }
            
        }
        return 0;
        
    }
    
    static int Binary(int[] arr, int target, int start, int end) {
        
        int mid = 0;
        while (start <= end) {
            mid = end + (start - end) / 2;
            
            if (arr[mid] < target) {
                start = mid + 1;
            }
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
        
    }
}