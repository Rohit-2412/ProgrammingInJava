package DSA.Matrix;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[][] a = {{16, 28, 60, 64},
                     {22, 41, 63, 91},
                     {27, 50, 87, 93},
                     {36, 78, 87, 94}};
        System.out.println(kthSmallest(a, 4, 2));
    }
    
    static int kthSmallest(int[][] mat, int n, int k) {
        if (k == 1) return mat[0][0];
        
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        while (low < high) {
            
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = n - 1;
            
            // find out how many numbers are greater than mid
            // between low and high
            for (int i = 0; i < n; i++) {
                
                while (j >= 0 && mat[i][j] > mid) j--;
                
                count += j + 1;
                
            }
            
            // if number of such element is less than k
            // narrow the search range by increasing lo value
            if (count < k) {
                low = mid + 1;
            }
            
            // if number of such element is greater or equal to k
            // narrow the search range by decreasing hi value
            
            else {
                high = mid;
            }
        }
        return low;
    }
}
