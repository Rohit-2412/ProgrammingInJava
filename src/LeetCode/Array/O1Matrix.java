package LeetCode.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    public static void main(String[] args) {
        int[][] nums = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0,}
        };
        int[][] ans = updateMatrix(nums);
        System.out.println(Arrays.toString(ans[0]));
        System.out.println(Arrays.toString(ans[1]));
        System.out.println(Arrays.toString(ans[2]));
    }
    
    public static int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] ans = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        // putting 0 in matrix as length 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }
                else {
                    ans[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            // checking for valid index
            if (isValid(i + 1, j, rows, cols) && ans[i + 1][j] == -1) {
                ans[i + 1][j] = ans[i][j] + 1;
                q.add(new int[]{i + 1, j});
            }
            if (isValid(i - 1, j, rows, cols) && ans[i - 1][j] == -1) {
                ans[i - 1][j] = ans[i][j] + 1;
                q.add(new int[]{i - 1, j});
            }
            if (isValid(i, j + 1, rows, cols) && ans[i][j + 1] == -1) {
                ans[i][j + 1] = ans[i][j] + 1;
                q.add(new int[]{i, j + 1});
                
            }
            if (isValid(i, j - 1, rows, cols) && ans[i][j - 1] == -1) {
                ans[i][j - 1] = ans[i][j] + 1;
                q.add(new int[]{i, j - 1});
            }
            q.poll();
        }
        return ans;
    }
    
    public static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
