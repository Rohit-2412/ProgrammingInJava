package DSA.Matrix;

import java.util.ArrayList;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20},
                       {21, 22, 23, 24}};
        System.out.println(spirallyTraverse(arr));
    }
    
    static ArrayList<Integer> spirallyTraverse(int[][] matrix) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return nums;
        }
        
        // Initialising boundary variables of matrix.
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        while (nums.size() < size) {
//            Traversing the matrix from first row, first column to the end of first row.
            for (int i = left; i <= right && nums.size() < size; i++) {
                nums.add(matrix[top][i]);
            }
            top++; // Incrementing the top variable for limiting the Boundary.

//            Traversing Top to bottom.
            for (int i = top; i <= bottom && nums.size() < size; i++) {
                nums.add(matrix[i][right]);
            }
            right--; //            Shifting the right variable by One value.

//            Traversing from right to left.
            for (int i = right; i >= left && nums.size() < size; i--) {
                nums.add(matrix[bottom][i]);
            }
//            Decreasing the bottom by one.
            bottom--;

//            Traversing from bottom left to top left.
            for (int i = bottom; i >= top && nums.size() < size; i--) {
                nums.add(matrix[i][left]);
            }
            // Increasing left boundary by one
            left++;
        }
        return nums;
    }
}
