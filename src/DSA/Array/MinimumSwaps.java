package DSA.Array;

public class MinimumSwaps {
    
    public static int minSwap(int[] arr, int n, int k) {
        // count variable for number of elements smaller than K
        int c = 0;
        
        for (int i = 0; i < n; i++) {
            // if a number is smaller, then Increment c
            if (arr[i] <= k) c++;
        }
        
        // variable for getting number greater than K
        // in window of size c,
        // c - b = min number of swaps in first window
        int b = 0;
        for (int i = 0; i < c; i++) {
            if (arr[i] > k) b++;
        }
        
        int ans = b;
        
        for (int i = 0, j = c; j < n; i++, j++) {
            // if number is greater at start of window,
            // then decreasing answer by 1
            // because we can shrink the window
            if (arr[i] > k) b--;
            
            // if number is greater at end of window
            // then increasing answer by 1
            if (arr[j] > k) b++;
            
            ans = Math.min(ans, b);
        }
        return ans;
    }
}
