package DSA.Array;
// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

/**
 * In share trading, a buyer buys shares and sells on a future date. Given the stock price of N days, the trader is
 * allowed to make at most K transactions, where a new transaction can only start after the previous transaction is
 * complete. The task is to find out the maximum profit that a share trader could have made.
 */
public class BuySellKTimes {
    public static void main(String[] args) {
    
    }
    
    static int profitBySellingKTimes(int[] prices, int n, int k) {
// greedy approach
        
        /*
        int ans = 0, buy = 0, sell = 0;
        Stack<int[]> transaction = new Stack<>();
        PriorityQueue<Integer> profits = new PriorityQueue<>(); // min heap
        
        while (sell < n) {
            buy = sell;
            
            // Find the farthest decreasing span
            // of prices before prices rise
            while (buy < n - 1 && prices[buy] >= prices[buy + 1]) {
                buy++;
            }
            
            sell = buy + 1;
            
            // Find the farthest increasing span
            // of prices before prices fall again
            while (sell < n && prices[sell] >= prices[sell - 1]) {
                sell++;
            }
            
            while (!transaction.isEmpty() && prices[buy] < prices[transaction.peek()[0]]) {
                int[] p = transaction.peek();
                
                profits.add(prices[p[1] - 1] - prices[p[0]]);
                transaction.pop();
            }
            
            while (!transaction.isEmpty() && prices[sell - 1] > prices[transaction.peek()[1] - 1]) {
                int[] p = transaction.peek();
                
                profits.add(prices[p[1] - 1] - prices[buy]);
                
                buy = p[0];
                
                transaction.pop();
            }
            
            transaction.push(new int[]{buy, sell});
        }
        
        while (!transaction.isEmpty()) {
            profits.add(prices[transaction.peek()[1] - 1] - prices[transaction.peek()[0]]);
            
            transaction.pop();
        }
        
        while (k > 0 && !profits.isEmpty()) {
            ans += profits.peek();
            profits.poll();
            --k;
        }
        
        return ans;
        
*/

//         dynamic programming approach

/*
         table to store results
         of subproblems
         profit[t][i] stores
         maximum profit using
         atmost t transactions up
         to day i (including day i)
        */
        
        int[][] profit = new int[k + 1][n + 1];
    
        /*
         For day 0, you can't
         earn money irrespective
         of how many times you trade
        */
        for (int i = 0; i <= k; i++) {
            profit[i][0] = 0;
        }

//        profit is 0 if we don't do any transaction
        for (int j = 0; j <= n; j++) {
            profit[0][j] = 0;
        }
        
        // filling up the table in bottom up
        
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int maxTillNow = 0;
                
                for (int m = 0; m < j; m++) {
                    maxTillNow = Math.max(maxTillNow, prices[j] - prices[m] + profit[i - 1][m]);
                    
                    profit[i][j] = Math.max(profit[i][j - 1], maxTillNow);
                }
            }
        }
        
        return profit[k][n-1];
    }
}
