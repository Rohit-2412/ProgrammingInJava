package DSA.Matrix;

import java.util.Arrays;

// Given an n x n matrix mat[n][n] of integers, find the maximum value of mat(c, d) – mat(a, b) over all choices of
// indexes such that both c > a and d > b.
public class FindPair {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, 6 },
                { 0, -4, 10, -5, 1
                }
        };

        System.out.println(findMaxValue(arr, 5));
    }

    static int findMaxValue(int[][] mtx, int n) {
        // ans variable
        int ans = Integer.MIN_VALUE;

        // maxArr[i][j] stores max of elements in matrix
        // from (i, j) to (N-1, N-1)
        int[][] maxArr = new int[n][n];

        maxArr[n - 1][n - 1] = mtx[n - 1][n - 1];

        // Preprocessing the last column.
        int maxVal = mtx[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (mtx[i][n - 1] > maxVal)
                maxVal = mtx[i][n - 1];

            maxArr[i][n - 1] = maxVal;
        }
        // Preprocessing the last row.
        maxVal = mtx[n - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (mtx[n - 1][j] > maxVal)
                maxVal = mtx[n - 1][j];

            maxArr[n - 1][j] = maxVal;
        }

        // Processing the rest of matrix from bottom.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if ((mtx[i + 1][j + 1] - mtx[i][j]) > ans) {
                    ans = maxArr[i + 1][j + 1] - mtx[i][j];
                }

                maxArr[i][j] = Math.max(mtx[i][j], Math.max(maxArr[i + 1][j], maxArr[i][j + 1]));
            }
        }

        for (int[] a : maxArr) {
            System.out.println(Arrays.toString(a));
        }
        return ans;
    }
}
