// 09-08-2022 18:24 August
/*
Gergovia consists of one street, and every inhabitant of the city is a wine salesman. Everyone buys wine from other
inhabitants of the city. Every day each inhabitant decides how much wine he wants to buy or sell. Interestingly,
demand and supply is always the same, so that each inhabitant gets what he wants.

There is one problem, however: Transporting wine from one house to another results in work. Since all wines are
equally good, the inhabitants of Gergovia don't care which persons they are doing trade with, they are only
interested in selling or buying a specific amount of wine.

In this problem you are asked to reconstruct the trading during one day in Gergovia. For simplicity we will assume
that the houses are built along a straight line with equal distance between adjacent houses. Transporting one bottle
of wine from one house to an adjacent house results in one unit of work.

Input
The input consists of several test cases.

Each test case starts with the number of inhabitants N (2 ≤ N ≤ 100000).

The following line contains n integers ai (-1000 ≤ ai ≤ 1000).

If ai ≥ 0, it means that the inhabitant living in the ith house wants to buy ai bottles of wine. If ai < 0, he wants
to sell -ai bottles of wine.

You may assume that the numbers ai sum up to 0.

The last test case is followed by a line containing 0.

Output
For each test case print the minimum amount of work units needed so that every inhabitant has his demand fulfilled.

Example
Input:
5
5 -4 1 -3 1
6
-1000 -1000 -1000 1000 1000 1000
0

Output:
9
9000
 */

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class GergoviaTrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // +ve = buy
        // -ve = sell
        ArrayList<int[]> sell = new ArrayList<>();
        ArrayList<int[]> buy = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int ints = arr[i];
            if (ints > 0) {
                buy.add(new int[] {arr[i], i});
            }
            else {
                sell.add(new int[] {arr[i], i});
            }
        }
        int ans = 0;
        int i = 0, j = 0;
        
        while (sell.size() > j && buy.size() > i) {
            int cost = Math.min(buy.get(i)[0], -sell.get(j)[0]);
            buy.get(i)[0] -= cost;
            sell.get(j)[0] += cost;
            int diff = Math.abs(buy.get(i)[1] - sell.get(j)[1]);
            ans += diff * cost;
            
            if (buy.get(i)[0] == 0) i++;
            if (sell.get(j)[0] == 0) j++;
        }
        System.out.println(ans);
    }
}
