// 10-07-2022 14:44 July
/*
Minimize Cash Flow among a given set of friends who have borrowed money from each other

Difficulty Level : Hard
Last Updated : 04 Feb, 2022
Given a number of friends who have to give or take some amount of money from one another. Design an algorithm by
which the total cash flow among all the friends is minimized.

Example:

Following diagram shows input debts to be settled.


 */

package DSA.Greedy;

public class MinimizeCashFlow {
    static final int N = 3;
    
    public static void main(String[] args) {
        // graph[i][j] indicates the amount
        // that person i needs to pay person j
        int[][] graph = {{0, 1000, 2000},
                         {0, 0, 5000},
                         {0, 0, 0}};
        
        // Print the solution
        minCashFlow(graph);
    }
    
    static int getMin(int[] arr) {
        int minIdx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        return minIdx;
    }
    
    static int getMax(int[] arr) {
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }
    
    static void minCashFlowUtil(int[] amt) {
        // find idx of min and max value in array
        int maxCredit = getMax(amt);
        int maxDebit = getMin(amt);
        
        // if both are 0 then all amounts are settled
        if (amt[maxDebit] == 0 && amt[maxCredit] == 0) return;
        
        int min = Math.min(-amt[maxDebit], amt[maxCredit]);
        amt[maxCredit] -= min;
        amt[maxDebit] += min;
        
        System.out.println("Person " + maxDebit + " pays " + min + " to " + "Person " + maxCredit);
        minCashFlowUtil(amt);
    }
    
    static void minCashFlow(int[][] graph) {
        int[] amount = new int[N];
        
        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                amount[p] += graph[i][p] - graph[p][i];
            }
        }
        minCashFlowUtil(amount);
    }
}
