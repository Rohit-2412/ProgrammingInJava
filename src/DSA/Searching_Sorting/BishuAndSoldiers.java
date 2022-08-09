package DSA.Searching_Sorting;

import java.util.Scanner;

import static java.lang.System.out;

/*
Problem
Bishu went to fight for Coding Club. There were N soldiers with various powers. There will be Q rounds to fight and
in each round, Bishu's power will be varied. With power M, Bishu can kill all the soldiers whose power is less than
or equal to M(<=M). After each round, All the soldiers who are dead in the previous round will reborn. Such that in
each round there will be N soldiers to fight. As Bishu is weak in mathematics, help him to count the number of
soldiers that he can kill in each round and the total sum of their powers.

INPUT:

The first line of the input contains N, the number of soldiers.

The second line contains an array of N numbers denoting the power of each soldier

This third line contains Q, which denotes the number of rounds.

Q lines follow, each line having one number denoting the power of Bishu.

OUTPUT:

For each round, the output should be an array of two numbers. The first number should be the number of soldiers that
Bishu can beat, and the second number denotes the cumulative strength of all the soldiers that Bishu can beat.

CONSTRAINTS:

1<=N<=10000

1<=power of each soldier<=100

1<=Q<=10000

1<=power of bishu<=100
 */
public class BishuAndSoldiers {
    public static void main(String[] args) {
        out.print("Enter number of enemies : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        sc.nextLine();
        
        Integer[] enemies = new Integer[n];
        
        out.print("Enter their powers : ");
        for (int i = 0; i < n; i++) {
            enemies[i] = sc.nextInt();
        }
        sc.nextLine();
        
        Integer[] prefixSum = new Integer[n];
        
        prefixSum[0] = enemies[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + enemies[i];
        }
        
        out.print("Enter number of rounds: ");
        int r = Integer.parseInt(sc.next().trim());
        
        for (int i = 0; i < r; i++) {
            out.print("Enter power of bishu : ");
            int power = Integer.parseInt(sc.next().trim());
            solve(enemies, prefixSum, power);
        }
    }
    
    private static void solve(Integer[] enemies, Integer[] prefixSum, int power) {
        int low = 0;
        int high = enemies.length - 1;
        int floor = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (power < enemies[mid]) {
                high = mid - 1;
            }
            // else if(power >= enemies[mid]
            else {
                floor = mid;
                low = mid + 1;
                
            }
        }
        if (floor != -1) {
            out.println((floor + 1) + " " + prefixSum[floor]);
        }
        else {
            out.println("He cannot defeat any enemy!");
        }
    }
}
