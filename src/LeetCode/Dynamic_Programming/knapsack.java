package LeetCode.Dynamic_Programming;

import java.util.Scanner;


public class knapsack {
    static final int N = (int) 1e3; // declaring a maximum limit of items as per question / problem statement
    
    static int[][] dp = new int[N][N]; // declaring a 2D array to store our computed answers
    
    static int[] weight = new int[N]; // declaring weight array, which will store the weight of the items
    // we're declaring it globally so that during the recursive calls we don't have to pass the array again and again
    
    static int[] value = new int[N]; // declaring value array which will store the value of item corresponding to weight array's idx
    // we're declaring it globally so that during the recursive calls we don't have to pass the array again and again
    
    public static void main(String[] args) {
        // filling cells of dp array with -1
        // using nested for loop from 0 to N
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        
        // Creating an object of scanner class to take user input
        Scanner sc = new Scanner(System.in);
        
        // Initializing variable n number of elements / items in array which is available for choosing
        int n;
        // Giving message to user
        System.out.println("Enter number of items");
        n = sc.nextInt(); // taking input
    
        // Giving message to user
        System.out.println("Enter weight of " + n + " items");
        // using for loop for taking n inputs of weights of n items
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        
        
        System.out.println("Enter value of " + n + " items");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        
        // declaring weight variable
        // giving message to user
        System.out.println("Enter maximum capacity of knapsack");
        int w;
        w = sc.nextInt();
        
        // storing our answer in a variable
        int profit = helper(n, w); // calling the helper function to calculate our answer
        
        // displaying answer with a message
        System.out.println("Maximum profit obtained : " + profit);
    }
    
    // function to do task
    // it is receiving number of items and maxWeight as arguments
    private static int helper(int n, int w) {
        // if weight becomes negative or 0 we can't compute answer so returning 0
        if (w <= 0) return 0;
        
        // if number of items is 0 or negative we can't proceed further so returning 0
        if (n <= 0) return 0;
        
        // checking if we have already computed this answer or not
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        
        
        if (weight[n - 1] > w) {
            dp[n][w] = helper(n - 1, w);
        }
        
        else {
            dp[n][w] = Math.max(helper(n - 1, w), helper(n - 1, w - weight[n - 1]) + value[n - 1]);
        }
        return dp[n][w];
    }
    
}
