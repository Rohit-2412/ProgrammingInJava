package DSA.Searching_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SquareFromMatrix {
    static int[][] matrix1;
    static int[][] matrix2;
    static int comparison = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String input = br.readLine();
        String[] parts = input.split(" ");
        
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
        matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            parts = input.split(" ");
            
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = Integer.parseInt(parts[i]);
            }
        }
        
        input = br.readLine();
        parts = input.split(" ");
        
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        matrix2 = new int[x][y];
        
        for (int i = 0; i < x; i++) {
            input = br.readLine();
            parts = input.split(" ");
            
            for (int j = 0; j < y; j++) {
                matrix2[i][j] = Integer.parseInt(parts[i]);
            }
        }
        int min = m;
        
        if (n < m) min = n;
        
        if (x < min) min = x;
        
        if (y < min) min = y;
        
        System.out.println(calc(0, min, m, n, x, y, min));
    }
    
    static int calc(int start, int end, int n, int m, int x, int y, int maxSquareSide) {
        
        if (start == 0 && end == 0) return 0;
        
        int mid = start + (end - start) / 2;
        
        if (compareAllSquares(mid, n, m, x, y)) {
            if (!compareAllSquares(mid + 1, n, m, x, y)) {
                return mid;
            }
            
            if (mid + 1 <= maxSquareSide) {
                return calc(mid + 1, end, n, m, x, y, maxSquareSide);
            }
            
            else {
                return mid;
            }
        }
        return -1;
    }
    
    private static boolean compareAllSquares(
            int size, int n, int m, int x, int y) {
        
        for (int row1 = 0; row1 + size - 1 < n; row1++) {
            for (int col1 = 0; col1 + size - 1 < m; col1++) {
                for (int row2 = 0; row2 + size - 1 < x; row2++) {
                    for (int col2 = 0; col2 + size - 1 < y; col2++) {
                        if (compareSquare
                                (row1, col1, row2, col2, size)) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private static boolean compareSquare(int sq1Row, int sq1Col, int sq2Row, int sq2Col, int size) {
        comparison++;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix1[sq1Row + i][sq2Col + j]
                        != matrix2[sq2Row + i][sq2Col + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
