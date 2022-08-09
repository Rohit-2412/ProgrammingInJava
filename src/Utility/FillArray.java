package Utility;

import java.util.Arrays;
import java.util.Random;

public class FillArray {
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(fill(50, 50)));
        System.out.println(Arrays.toString(fill(5)));
    }
    
    public static int[] fill(int n, int limit) {
        int[] ans = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ans[i] = random.nextInt(limit);
        }
        return ans;
    }
    
    public static int[] fill(int n) {
        int[] ans = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ans[i] = random.nextInt(100);
        }
        return ans;
    }
}
