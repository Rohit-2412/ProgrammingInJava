// 09-10-2022 15:10 October

package DSA.Stack;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] m = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(celebrity(m, m.length));
    }
    
    static int celebrity(int[][] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            if (arr[a][b] == 1) {
                stack.push(b);
            }
            else {
                stack.push(a);
            }
            
        }
        
        int ans = stack.pop();
        int zeroCount = 0, oneCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[ans][i] == 0) {
                zeroCount++;
            }
            if (arr[i][ans] == 1) {
                oneCount++;
            }
        }
        
        return zeroCount == n && oneCount == n - 1 ? ans : -1;
    }
    
}
