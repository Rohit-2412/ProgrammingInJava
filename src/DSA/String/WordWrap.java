package DSA.String;

/*
Given an array nums[] of size n, where nums[i] denotes the number of characters in one word. Let K be the limit on
the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that
the lines are printed neatly.
Assume that the length of each word is smaller than the line width. When line breaks are inserted there is a
possibility that extra spaces are present in each line. The extra spaces include spaces put at the end of every line
except the last one.

You have to minimize the following total cost where total cost = Sum of cost of all lines, where cost of line is =
(Number of extra spaces in the line)
 */

public class WordWrap {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 5};
        System.out.println(solveWordWrap(arr, 6));
    }
    
    static int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int inf = Integer.MAX_VALUE;
        // space[i][j] => Number of spaces if we store from ith word to jth word
        int[][] space = new int[n][n]; // Initializing the space DP table.

//        Traversing the array and storing the number of spaces if we're storing only the current word
        for (int i = 0; i < n; i++) {
            space[i][i] = k - nums[i]; // limit - length of word
            
            for (int j = i + 1; j < n; j++) {
                // storing spaces if we keep the next word also -> like 1st with 2nd with 3rd with 4th ...(Trying all
                // possible combinations)
                space[i][j] = space[i][j - 1] - nums[j] - 1;
            }
        }
        
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (space[i][j] < 0) {
                    cost[i][j] = inf;
                }
                else {
                    // If it's the last word, then spaces count will be 0.
                    if (j == n - 1) {
                        cost[i][j] = 0;
                    }
                    else {
                        cost[i][j] = space[i][j] * space[i][j]; // Calculating the cost.
                    }
                }
            }
        }
        
        int[] min_cost = new int[n];
//      traversing in reverse direction
        for (int i = n - 1; i >= 0; i--) {
            min_cost[i] = cost[i][n - 1];
            for (int j = n - 1; j > i; j--) {
                if (cost[i][j - 1] == inf) continue;
                // Calculating the optimal cost.
                if (cost[i][j - 1] + min_cost[j] < min_cost[i]) {
                    min_cost[i] = cost[i][j - 1] + min_cost[j];
                }
            }
        }
        
        return (min_cost[0]);
    }
}