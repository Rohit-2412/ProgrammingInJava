// 10-07-2022 12:44 July
/*
Buy Maximum Stocks if i stocks can be bought on i-th day

Difficulty Level : Easy
Last Updated : 27 Aug, 2021
In a stock market, there is a product with its infinite stocks. The stock prices are given for N days, where arr[i]
denotes the price of the stock on the ith day. There is a rule that a customer can buy at most i stock on the ith day
. If the customer has an amount of k amount of money initially, find out the maximum number of stocks a customer can
buy.

For example, for 3 days the price of a stock is given as 7, 10, 4. You can buy 1 stock worth 7 rs on day 1, 2 stocks
worth 10 rs each on day 2 and 3 stock worth 4 rs each on day 3.

Examples:

Input : price[] = { 10, 7, 19 },
              k = 45.
Output : 4
A customer purchases 1 stock on day 1,
2 stocks on day 2 and 1 stock on day 3 for
10, 7 * 2 = 14 and 19 respectively. Hence,
total amount is 10 + 14 + 19 = 43 and number
of stocks purchased is 4.

Input  : price[] = { 7, 10, 4 },
               k = 100.
Output : 6
 */

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class BuyMaxStocks {
    public static void main(String[] args) {
        int[] arr = {10, 7, 19};
        System.out.println(buyMaximumProducts(3, 45, arr));
    }
    
    static int buyMaximumProducts(int n, int totalAmount, int[] price) {
        int stocks = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {i + 1, price[i]});
        }
        
        list.sort(Comparator.comparingInt(a -> a[1]));
//        a[] = day number, stock price
        for (int[] a : list) {
            int numberOfStock = Math.min(a[0], totalAmount / a[1]);
            stocks += numberOfStock; // this will give number of stocks we can buy
            totalAmount -= a[1] * numberOfStock; // stock price * number of stocks
        }
        return stocks;
    }
    
}
