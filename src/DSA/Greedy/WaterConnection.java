// 06-07-2022 12:27 July

package DSA.Greedy;

import java.util.ArrayList;
import java.util.HashMap;

public class WaterConnection {
    
    static ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b,
            ArrayList<Integer> d) {
        int[] waterIn = new int[n + 1];
        int[] waterOut = new int[n + 1];
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p; i++) {
            waterIn[b.get(i)]++;
            waterOut[a.get(i)]++;
            map.put(a.get(i), i);
        }
        
        for (int source = 0; source < n + 1; source++) {
            if (waterIn[source] == 0 && waterOut[source] == 1) {
                int[] arr = solve1(source, a, b, d, map);
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(source);
                list1.add(arr[1]);
                list1.add(arr[0]);
                ans.add(new ArrayList<>(list1));
            }
        }
        return ans;
    }
    
    static int[] solve1(int src, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d,
            HashMap<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        
        while (map.containsKey(src)) {
            min = Math.min(min, d.get(map.get(src)));
            src = b.get(map.get(src));
        }
        return new int[] {min, src};
    }
    
}
