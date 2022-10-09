package DSA.String;

import java.util.*;

public class NextGreaterNumber {
    static List<Integer> greaterNumber(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int infPt = 0;
        int n = nums.length - 1;
        for (int i = n; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                infPt = i;
                break;
            }
        }
        if (infPt == 0) {
            Arrays.sort(nums);
            for (int num : nums) ans.add(num);
            return ans;
        }
        else {
            int toSwap = nums[infPt - 1];
            int min = Integer.MAX_VALUE;
            for (int j = infPt; j <= n; j++) {
                if ((nums[j] - toSwap) > 0 && (nums[j] - toSwap) < min) {
                    int temp = nums[j];
                    nums[j] = nums[infPt - 1];
                    nums[infPt - 1] = temp;
                }
            }
        }
        Arrays.sort(nums, infPt, nums.length);
        for (int num : nums) ans.add(num);
        return ans;
    }
}
