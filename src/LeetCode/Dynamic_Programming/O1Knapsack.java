package LeetCode.Dynamic_Programming;

import java.util.Scanner;

public class O1Knapsack {
    
    // main function
    public static void main(String[] args) {
        
        // Creating an object of scanner class to take user input
        Scanner sc = new Scanner(System.in);
        
        // Initializing variable n number of elements / items in array which is available for choosing
        int n;
        // Giving message to user
        System.out.println("Enter number of items");
        n = sc.nextInt(); // taking input
        
        int[] weight = new int[n];
        // Giving message to user
        System.out.println("Enter weight of " + n + " items");
        // using for loop for taking n inputs of weights of n items
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        
        
        int[] value = new int[n];
        System.out.println("Enter value of " + n + " items");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        
        // declaring weight variable
        // giving message to user
        System.out.println("Enter maximum capacity of knapsack");
        int maxWeight;
        maxWeight = sc.nextInt();
        
        int[] dp = new int[maxWeight + 1];
        // filling cells of dp array with 0
        // using nested for loop from 0 to N
        for (int i = 0; i < maxWeight + 1; i++) {
            dp[i] = 0;
        }
        
        // dynamic programming
        // bottom up approach
        
        // running first for loop from [0 to weight]
        // here we will try to compute if there exists some answer for max weight 0 1 2 3 ...
        for (int j = 0; j <= maxWeight; j++) {
            
            // running next for loop from 0 to n
            // this loop is for traversing the weight array and value array
            for (int i = 0; i < n; i++) {
                
                // checking if the difference between current weight and weight of first item is greater than 0
                // implies we can pick that item or not
                
                if (j - weight[i] >= 0) {
                    
                    // if we can pick that item then
                    // storing the Maximum of current profit and profit till now(if we skip that item)
                    // dp[j] indicates :: if we don't pick that item
                    // value[i] + dp[j - weight[i]] indicates :: if we have picked that element then adding its cost plus
                    // profit which we have can obtain from remaining weight of knapsack
                    dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
                }
            }
        }
        
        // storing our answer in a variable
        int profit = dp[maxWeight];
        
        // displaying answer with a message
        System.out.println("Maximum profit obtained : " + profit);
        
    }
}