package DSA.Searching_Sorting;

import java.util.Arrays;

public class PairDifference {
    static boolean findPair(int[] arr, int size, int n) {
        
        if (n == 0) return false;
        
        Arrays.sort(arr);
        int diff = 0;
        for (int i = 0; i < size; i++) {
            int a = arr[i];
            diff = Math.abs(n + a);
            
            int low = 0, high = size - 1;
            int mid = low + (high - low) / 2;
            
            while (low <= high) {
                if (arr[mid] == diff) {
                    return true;
                }
                else if ((arr[mid]) > diff) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
                mid = low + (high - low) / 2;
            }
        }
        return false;
    }
}
