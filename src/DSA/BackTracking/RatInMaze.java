// 10-08-2022 20:17 August
/*
Rat in a Maze Problem - I
MediumAccuracy: 37.73%Submissions: 100k+Points: 4
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.

Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
 Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat
 can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is
 blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other
 cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1},
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at
(3, 3) from (0, 0) by two paths - DRDDRR
and DDRDRR, when printed in sorted order
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is
blocked
 */

package DSA.BackTracking;

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        
        System.out.println(findPath(m, 4));
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        String ans = "";
        
        if (!helper(0, 0, m, arrayList, ans)) {
            arrayList.add("-1");
        }
        return arrayList;
    }
    
    private static boolean helper(int x, int y, int[][] m, ArrayList<String> arrayList, String ans) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || m[x][y] == 0) return false;
        
        if (x == m.length - 1 && y == m[0].length - 1) {
            arrayList.add(ans);
            return true;
        }
        
        m[x][y] = 0;
        boolean left = helper(x, y - 1, m, arrayList, ans + 'L');
        boolean right = helper(x, y + 1, m, arrayList, ans + 'R');
        boolean up = helper(x - 1, y, m, arrayList, ans + 'U');
        boolean down = helper(x + 1, y, m, arrayList, ans + 'D');
        
        m[x][y] = 1;
        return up || right || left || down;
    }
    
}
