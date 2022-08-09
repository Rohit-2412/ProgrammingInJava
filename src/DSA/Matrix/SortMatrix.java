package DSA.Matrix;

import java.util.Arrays;
import java.util.PriorityQueue;

// Given an NxN matrix Mat. Sort all elements of the matrix.
public class SortMatrix {
    
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};
        int[][] temp = sortedMatrix(4, mat);
        for (int[] a : temp) {
            System.out.println(Arrays.toString(a));
        }
    }
    
    static int[][] sortedMatrix(int n, int[][] mat) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // min heap
        for (int[] a : mat) {
            for (int num : a)
                heap.add(num);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!heap.isEmpty()) {
                    mat[i][j] = heap.poll();
                }
            }
        }
        return mat;
    }
}
