package LeetCode.Array;

public class NegativeInGrid {
    public static void main(String[] args) {
        int[][] arr = {{4, 3, 2, -1}, {3, 2, 1, -1}};
        System.out.println(countNegatives(arr));
    }
    
    public static int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] ints : grid) {
            for (int number : ints) {
                if (number < 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
