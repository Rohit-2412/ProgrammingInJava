// 15-08-2022 14:18 August

package DSA.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    static boolean[] cols;
    static boolean[] leftDiagonal;
    static boolean[] rightDiagonal;
    
    public static void main(String[] args) {
        for (List<Integer> l : nQueen(5)) {
            System.out.println(l);
        }
    }
    
    static List<List<Integer>> nQueen(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            temp.add(0);
        }
        
        nQueenHelper(result, n, 0, temp);
        return result;
    }
    
    private static void nQueenHelper(List<List<Integer>> result, int n, int row, List<Integer> temp) {
        if (row == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n]) continue;
            
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = true;
            temp.set(col, row + 1);
            nQueenHelper(result, n, row + 1, temp);
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = false;
        }
        
    }
    
}
