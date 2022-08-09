package LeetCode.Array;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
    
    }
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            if (idx.containsKey(target - nums[i])) {
                return new int[]{idx.get(target - nums[i]), i};
            }
            idx.put(nums[i], i);
        }
        return null;
    }
}
