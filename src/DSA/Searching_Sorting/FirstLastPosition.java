package DSA.Searching_Sorting;

import java.util.ArrayList;

public class FirstLastPosition {
    
    static int search(long[] nums, int target, boolean findStartIdx) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1; // initially we assume no answer possible
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                if (findStartIdx) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    
    ArrayList<Long> find(long[] arr, int n, int target) {
        ArrayList<Long> ans = new ArrayList<>();
        long start = search(arr, target, true);
        long end = search(arr, target, false);
        ans.add(start);
        ans.add(end);
        
        return ans;
    }
    
}
