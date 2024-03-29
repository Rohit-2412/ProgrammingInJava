package DSA.Array;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = { -4 };
        System.out.println(maxProduct(arr, arr.length));
    }

    static long maxProduct(int[] arr, int n) {
        long minVal = arr[0];
        long maxVal = arr[0];
        long ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            // swap maxval and minval
            if (num < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            // compute the max and min
            maxVal = Math.max(num, maxVal * num);
            minVal = Math.min(num, minVal * num);
            // update the ans
            ans = Math.max(ans, maxVal);
        }
        return ans;
    }
}
