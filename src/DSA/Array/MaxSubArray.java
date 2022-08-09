package DSA.Array;

public class MaxSubArray {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 4, 6, 4, 0, -9, 8, 7, 0, 6, 5, 4};
        int []arr={-1,-9,-2};
        System.out.println(maxSubarraySum(arr));
    }
    
    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int maxSum = arr[0];
        for (int j : arr) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += j;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
