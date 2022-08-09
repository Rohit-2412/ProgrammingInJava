package Questions;

import java.util.Scanner;

class Source {
    
    // function to return the minimum cost required to go to coordinate (m,n) in cost array
    private static int minCost(int[][] cost, int m, int n) {
        
        // declaring a minimumCost array of size m+1, n+1
        int[][] minimumCost = new int[m + 1][n + 1];
        
        minimumCost[0][0] = cost[0][0]; // cost to start from beginning is same as the value of first cell in cost array
        
        /* Initialise the first column of the minimum cost (table) array */
        // starting the loop from 1 so that we can add the value of one previous cell
        for (int col = 1; col <= m; col++) {
            // minimum cost of current cell =
            // minimum cost to reach the previous cell + cost of current cell
            minimumCost[col][0] = cost[col][0] + minimumCost[col - 1][0];
        }
        
        /* Initialise the first row of the table array */
        for (int row = 1; row <= n; row++) {
            // minimum cost of current cell =
            // minimum cost to reach the previous cell + cost of current cell
            minimumCost[0][row] = minimumCost[0][row - 1] + cost[0][row];
        }
        
        /* Construct the rest of the table array from the recursion relation */
        // nested for loop to go through each cell in minimum cost array
        
        // starting col from 1 so that we can use previous value / cost
        for (int col = 1; col <= m; col++) {
            
            // starting row from 1 so that we can use previous value/cost
            for (int row = 1; row <= n; row++) {
                
                // minimum cost of current cell =
                // minimum of {one cell upward , one cell left , one cell diagonally up} + cost of current cell
                
                // since does not support minimum of three values, so we will use nested Math.min function
                // Math.min(Math.min(a, b), c)
                
                minimumCost[col][row] = Math.min(Math.min(minimumCost[col - 1][row], minimumCost[col][row - 1]),
                        minimumCost[col - 1][row - 1]) + cost[col][row];
            }
        }
        
        // returning the minimum cost which will be stored at minimum cost[col][row]
        return minimumCost[m][n];
    }
    
    // main function
    public static void main(String[] args) {
        // cost array storing the cost of each cell
        int[][] cost = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};
        // Scanner class object to take user input and store it in variable
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt(); // storing xCoordinate value
        int yCoordinate = scan.nextInt(); // storing yCoordinate value
        // calling the function with arguments as: cost array(2-D), xCoordinate and yCoordinate
        // printing the value returned by the function to the screen / console
        System.out.println(minCost(cost, xCoordinate, yCoordinate));
    }
}