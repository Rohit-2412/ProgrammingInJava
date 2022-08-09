// 10-07-2022 10:04 July

package DSA.Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[] {900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[] {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, n));
    }
    
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int pf = 1;
        int max = 1;
        
        int j = 0, i = 1;
        
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                pf++;
                i++;
            }
            else {
                pf--;
                j++;
            }
            
            if (pf > max) max = pf;
        }
        return max;
    }
}
