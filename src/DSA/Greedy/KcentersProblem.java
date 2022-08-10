// 10-08-2022 14:00 August

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class KcentersProblem {
    public static void main(String[] args) {
        int n = 4;
        int[][] weights = new int[][] {{0, 4, 8, 5},
                                       {4, 0, 10, 7},
                                       {8, 10, 0, 9},
                                       {5, 7, 9, 0}};
        int k = 2;
        
        // Function Call
        selectKcities(n, weights, k);
    }
    
    static int maxIndex(int[] arr, int n) {
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
    
    static void selectKcities(int n, int[][] weights, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Integer> centers = new ArrayList<>();
        
        int max = 0;
        for (int i = 0; i < k; i++) {
            centers.add(max);
            
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], weights[max][j]);
    
                System.out.println(Arrays.toString(dist));
                System.out.println("max = " + max);
            }
            
            max = maxIndex(dist, n);
        }
        
        System.out.println(dist[max]);
        System.out.println(centers);
    }
}
