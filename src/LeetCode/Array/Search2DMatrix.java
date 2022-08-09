package LeetCode.Array;

public class Search2DMatrix {
    public static void main(String[] args) {
    
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;    // row length
        int col = matrix[0].length; // col length
        int r = 0;             // first row
        int c = col - 1;       // last element of first row
        // 2d binary search
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            
            else if (matrix[r][c] > target) {
                c--;
            }
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
