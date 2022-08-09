package DSA.Matrix;

import java.util.Stack;

public class MaxSizeRectangle {
    static int getMaxArea(int[] arr, int n) {
        // your code here
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int t = st.pop();
                int area = arr[t] * (st.isEmpty() ? i : i - st.peek() - 1);
                res = Math.max(res, area);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            
            int a = st.pop();
            int are = arr[a] * (st.isEmpty() ? n : n - st.peek() - 1);
            res = Math.max(res, are);
            
        }
        return res;
    }
    
    static int maxArea(int[][] mat, int n, int m) {
        // add code here.
        int res = getMaxArea(mat[0], m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
            res = Math.max(res, getMaxArea(mat[i], m));
            
        }
        return res;
        
    }
}
