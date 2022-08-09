package DSA.Searching_Sorting;

import java.util.Arrays;

/*
count the number of triplets whose sum is smaller than the given sum in an unsorted array.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        long[] arr = {-2, 0, 1, 3};
        System.out.println(countTriplets(arr, arr.length
                , 2));
    }
    
    static long countTriplets(long[] arr, int n, int sum) {
        long count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            
            if (arr[i] < sum) {
                int low = i + 1;
                int high = n - 1;
                
                while (low < high) {
                    long temp_sum = arr[low] + arr[high] + arr[i];
                    if (temp_sum < sum) {
                        count += (high - low);
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return count;
    }
}
