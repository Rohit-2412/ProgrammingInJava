// 10-07-2022 18:54 July
/*
A board of length m and width n is given, we need to break this board into m*n squares such that cost of breaking is
minimum. cutting cost for each edge will be given for the board. In short, we need to choose such a sequence of
cutting such that cost is minimized.
 */

package DSA.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class MinCostToCutIntoSquare {
    public static void main(String[] args) {
        int m = 6, n = 4;
        Integer[] x = {2, 1, 3, 1, 4};
        Integer[] y = {4, 1, 2};
        System.out.println(minCost(x, y, m - 1, n - 1));
    }
    
    static int minCost(Integer[] x, Integer[] y, int m, int n) {
        int result = 0;
        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());
        
        int horizontal = 1, vertical = 1;
        int i = 0, j = 0;
        
        while (i < m && j < n) {
            
            if (x[i] > y[j]) {
                result += x[i] * vertical;
                horizontal++;
                i++;
            }
            else {
                result += y[j] * horizontal;
                vertical++;
                j++;
            }
        }
        int total = 0;
        while (i < m) total += x[i++];
        result += total * vertical;
        
        total = 0;
        while (j < n) total += y[j++];
        result += total * horizontal;
        
        return result;
    }
}
