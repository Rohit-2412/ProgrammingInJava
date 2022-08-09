package DSA.Array;

/* In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is
allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first one is
 complete (Buy->sell->Buy->sell). Given stock prices throughout the day, find out the maximum profit that a share
 trader could have made. */
public class StockBuySellTwoTimes {
    public static void main(String[] args) {
        int[] price = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(maxProfit(price));
    }
    
    static int maxProfit(int[] price) {
        /*
 approach 1
        int n = price.length;
        int[] profit = new int[price.length];
        for (int i = 0; i < n; i++) {
            profit[i] = 0;
        }
        int max_price = price[n - 1];
        // profit after having one transaction only
        for (int i = n - 2; i >= 0; i--) {
            if (price[i] > max_price) max_price = price[i];
            
            profit[i] = Math.max(profit[i + 1], max_price - price[i]);
        }
        // after 2nd transaction
        int min_price = price[0];
        for (int i = 1; i < n; i++) {
            if (price[i] < min_price) min_price = price[i];
            
            profit[i] = Math.max(profit[i - 1], profit[i] + price[i] - min_price);
        }
        return profit[n - 1];
*/
        
        // approach 2
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;
        for (int i = 0; i < price.length; i++) {
            first_buy = Math.max(first_buy, -price[i]);
            
            first_sell = Math.max(first_sell, first_buy + price[i]);
            
            second_buy = Math.max(second_buy, first_sell - price[i]);
            
            second_sell = Math.max(second_sell, second_buy + price[i]);
        }
        return second_sell;
    }
}
