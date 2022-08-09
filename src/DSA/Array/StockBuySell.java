package DSA.Array;

import static java.lang.Math.max;

public class StockBuySell {
    public static void main(String[] args) {
        int []arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxP = 0, l = 0, r = 1;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                maxP = max(maxP, prices[r] - prices[l]);
            }
            // we have found a new min value
            else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
