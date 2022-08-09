package DSA.Matrix;

public class RotateMatrix {
    static void rotate(int[][] matrix) {
//       Swapping elements
        /*
         1    '2'    "3"
        '4'    5    ''6''
        "7"  ''8''    9
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (i != j) {
                    swap(matrix, i, j, j, i);
                }
            }
        }
        
        // swapping left to right column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                swap(matrix, i, j, i, matrix[i].length - j - 1);
            }
        }
    }
    
    static void swap(int[][] arr, int i, int j, int p, int q) {
        int temp = arr[i][j];
        arr[i][j] = arr[p][q];
        arr[p][q] = temp;
    }
    
}
