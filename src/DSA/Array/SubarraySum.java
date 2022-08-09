package DSA.Array;

import java.util.HashSet;
import java.util.Set;

//    Find if there is any subarray with sum equal to 0
public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = {3, 2, -3, 1, 6};
        System.out.println(subarraySum(arr));
    }
    
    public static boolean subarraySum(int[] arr) {
//        using prefix sum
//        if there comes same prefix sum two times then there is a 0 sum subarray
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == 0 || num == 0 || set.contains(sum)) return true;
            
            set.add(sum);
        }
        return false;
    }
}

