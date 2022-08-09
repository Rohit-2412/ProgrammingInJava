package DSA.Array;

import java.util.HashMap;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        System.out.println(getPairsCount(arr, arr.length, 2));
    }
    
    public static int getPairsCount(int[] nums, int n, int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        return count;
    }
}
