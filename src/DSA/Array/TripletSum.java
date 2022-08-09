package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    
    static boolean tripletSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1;
            int e = n - 1;
            while (s < e) {
                int currentSum = arr[i] + arr[s] + arr[e];
                if (currentSum == target) {
                    // if we have duplicates also then
                    return true;
                }
                
                else if (currentSum > target) {
                    e--;
                }
                
                else {
                    s++;
                }
            }
        }
        return false;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int s = i + 1;
                int e = n - 1;
                int sum = -nums[i];
                
                while (s < e) {
                    if (nums[s] + nums[e] == sum) {
                        // if we have duplicates also then
                        list.add(Arrays.asList(nums[i], nums[s], nums[e]));
                        
                        while (s < e && nums[s] == nums[s + 1]) s++;
                        while (s < e && nums[e] == nums[e - 1]) e--;
                        s++;
                        e--;
                    }
                    
                    else if (nums[s] + nums[e] > sum) {
                        e--;
                    }
                    
                    else {
                        s++;
                    }
                }
            }
        }
        return list;
    }
}
