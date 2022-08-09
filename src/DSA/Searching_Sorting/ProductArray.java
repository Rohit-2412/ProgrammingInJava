package DSA.Searching_Sorting;


/*
Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product
of all the elements of nums except nums[i].

Example 1:

Input:
n = 5
nums[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation:
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
 */
public class ProductArray {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
//        productExceptSelf(arr, arr.length);
    }
    
    public static long[] productExceptSelf(int[] arr, int n) {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }
        
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prefix;
            prefix *= arr[i];
        }
        
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= arr[i];
        }
        return ans;
    }
}
