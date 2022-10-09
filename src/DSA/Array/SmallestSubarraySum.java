package DSA.Array;

// Smallest Subarray with sum greater than a given value
public class SmallestSubarraySum {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 45, 6, 10, 19};
        int x = 51;
        System.out.println(smallestSubarray(arr1, arr1.length, x));
    }
    
    // Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
    static int smallestSubarray(int[] arr, int n, int sum) {
        int curr_sum = 0, min_len = n + 1;
        int s = 0, e = 0;
        
        while (e < n) {
            // Keep adding array elements while current sum
            // is smaller than or equal to x
            while (curr_sum <= sum && e < n) curr_sum += arr[e++];
    
            // If current sum becomes greater than x.
            while (curr_sum > sum && s < n) {
                // Update minimum length if needed
                if ((e - s) < min_len) min_len = e - s;
    
                // remove starting elements
                curr_sum -= arr[s++];
            }
        }
        return min_len;
    }
}
