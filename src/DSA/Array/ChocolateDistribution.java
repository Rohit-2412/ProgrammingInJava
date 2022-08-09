package DSA.Array;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {
    public static void main(String[] args) {
        long N = 8, M = 5;
//       A = {3, 4, 1, 9, 56, 7, 9, 12}
        ArrayList<Long> a = new ArrayList<>();
        a.add((long) 3);
        a.add((long) 4);
        a.add((long) 1);
        a.add((long) 9);
        a.add((long) 56);
        a.add((long) 7);
        a.add((long) 9);
        a.add((long) 12);
        System.out.println(findMinDiff(a, 8, 5));
        
    }
    
    static long findMinDiff(ArrayList<Long> a, long n, long m) {
        Collections.sort(a);
        long ans = Integer.MAX_VALUE;
        long i = 0;
        long j = i + m - 1;
        while (j < n) {
            long diff = a.get((int) j) - a.get((int) i);
            ans = Math.min(ans, diff);
            i++;
            j = i + m - 1;
        }
        return ans;
    }
}
