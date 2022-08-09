package DSA.Array;

import java.util.ArrayList;
import java.util.List;

// Maximum profit by buying and selling a share utmost twice
public class SubsetArray {
    public static void main(String[] args) {
    
    }
    
    static String checkSubarray(long[] arr, long[] sub) {
        List<Long> items = new ArrayList<>();
        for (long j : arr) {
            items.add(j);
        }
        for (long num : sub) {
            if (!items.contains(num)) return "No";
        }
        return "Yes";
    }
}
