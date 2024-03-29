package DSA.Searching_Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight
line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum
distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.
 */
public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- != 0) {
            int n;
            n = sc.nextInt();
            int c;
            c = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int ans = 0;
            int ub = (int) 1e9;
            int lb = 1;
            
            while (lb <= ub) {
                int mid = lb + (ub - lb) / 2;
                int prev = arr[0];
                int cow = 1;
                
                for (int i = 0; i < n; i++) {
                    if (arr[i] - prev >= mid) {
                        cow++;
                        prev = arr[i];
                        if (c == cow) break;
                    }
                }
                if (c == cow) {
                    ans = mid;
                    lb = mid + 1;
                }
                else {
                    ub = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
}
