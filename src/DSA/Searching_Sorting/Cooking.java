package DSA.Searching_Sorting;

import java.util.Scanner;

import static java.lang.System.out;

public class Cooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        
        for (int test = 0; test < t; test++) {
            int para;
            para = sc.nextInt();
            int n;
            n = sc.nextInt();
            int[] rank = new int[n];
            for (int j = 0; j < n; j++) {
                rank[j] = sc.nextInt();
            }
            
            int ans = 0;
            int lb = 0;
            int ub = (int) 1e2;
            while (lb <= ub) {
                int mid = lb + (ub - lb) / 2;
                if (solve(rank, para, mid)) {
                    ans = mid;
                    ub = mid - 1;
                }
                else {
                    lb = mid + 1;
                }
            }
            out.println(ans);
        }
        
    }
    
    private static boolean solve(int[] arr, int required, int limit) {
        int cooked = 0;
        int time;
        
        for (int i = 0; i < arr.length; i++) {
            time = arr[i];
            int j = 2;
            
            while (time <= limit) {
                cooked++;
                time += arr[i] * j++;
            }
            if (cooked >= required) {
                return true;
            }
        }
        return false;
    }
}
