package DSA.Matrix;

public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;
//        Starting from top right corner in the matrix.
        while (r < row && c >= 0) {
//            If we got the target, then we will return true.
            if (matrix[r][c] == target) {
                return true;
            }
//            If our current element is greater than target then we will shift column to the left by one.
            else if (matrix[r][c] > target) {
                c--;
            }
//            If our current element is smaller than the target, then we will shift row down by one.
            else if (matrix[r][c] < target) {
                r++;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
