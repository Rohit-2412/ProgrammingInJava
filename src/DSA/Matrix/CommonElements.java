package DSA.Matrix;

import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                        };
        
        System.out.println(common(mat, 5, 4));
    }
    
    static List<Integer> common(int[][] arr, int n, int m) {
        // By sorting each row in N(logn) time, then finding the common element.
        for (int[] temp : arr)
            Arrays.sort(temp);
        
        // A hash map to store count of elements
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,
                Integer> map = new HashMap<>();
        
        int i, j;
        for (i = 0; i < m; i++) {
            // Increment the count of first
            // element of the row
            if (map.containsKey(arr[i][0])) {
                map.put(arr[i][0], map.get(arr[i][0]) + 1);
            }
            else {
                map.put(arr[i][0], 1);
            }
            
            // Starting from the second element
            // of the current row
            for (j = 1; j < n; j++) {
                
                // If current element is different from
                // the previous element i.e. it is appearing
                // for the first time in the current row
                if (arr[i][j] != arr[i][j - 1]) {
                    if (map.containsKey(arr[i][j])) {
                        map.put(arr[i][j], map.get(arr[i][j]) + 1);
                    }
                    else {
                        map.put(arr[i][j], 1);
                    }
                }
            }
        }
        
        // Find element having count
        // equal to number of rows
        for (Map.Entry<Integer,
                Integer> ele : map.entrySet()) {
            if (ele.getValue() == m) {
                result.add(ele.getKey());
            }
        }
        
        return result;
        
    }
}
