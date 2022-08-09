package LeetCode.Array;

public class IslandArea {
    public static void main(String[] args) {
    
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, area(grid, i, j));
                }
            }
        }
        return max;
    }
    
    public int area(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += area(grid, i + 1, j);
        count += area(grid, i - 1, j);
        count += area(grid, i, j + 1);
        count += area(grid, i, j - 1);
        
        return count;
    }
}
