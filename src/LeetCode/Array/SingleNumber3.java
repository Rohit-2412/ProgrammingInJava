package LeetCode.Array;

import java.util.HashMap;

public class SingleNumber3 {
    public static void main(String[] args) {
    
    }
    
    public int singleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        for (int num : arr) {
            if (map.get(num) == 1) {
                ans = num;
            }
        }
        return ans;
    }
}
