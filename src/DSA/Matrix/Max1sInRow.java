package DSA.Matrix;

public class Max1sInRow {
    public static void main(String[] args) {
        int[][] Arr = {{0, 1, 1, 1},
                       {0, 0, 1, 1},
                       {1, 1, 1, 1},
                       {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(Arr, Arr.length, Arr[0].length));
    }
    
    static int rowWithMax1s(int[][] arr, int n, int m) {
        int res = -1;
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (arr[row][col] == 1) {
                    return row;
                }
            }
        }
        return res;
    }
}
