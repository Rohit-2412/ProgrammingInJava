package DSA.Searching_Sorting;

import java.util.Arrays;

public class SortByBitCount {
    
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 50, 458, 13, 12, 14, 15};
        sortBySetBitCount(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
    static void sortBySetBitCount(Integer[] arr, int n) {
        // sort in decreasing order
        Arrays.sort(arr,
                (a, b) -> Integer.compare(Integer.bitCount(b),
                        Integer.bitCount(a)));
    }
    
    static int bitCount(int num) {
        int ans = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }
}
