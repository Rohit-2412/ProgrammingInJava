package LeetCode.Array;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // adding 0 in the map
        int prefix = 0, count = 0;
        for (int num : numbers) {
            prefix += num;
            count += map.getOrDefault(prefix - target, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
