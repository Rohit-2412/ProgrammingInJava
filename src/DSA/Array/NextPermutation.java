package DSA.Array;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] nums) {
        int infPt = 0;
        int n = nums.length - 1;
        for (int i = n; i > 0; i--) {
            // condition for inflexion point
            if (nums[i] > nums[i - 1]) {
                infPt = i;
                break;
            }
        }
        // if no inflexion point
        if (infPt == 0) {
            Arrays.sort(nums);
            return;
        } else {
            int toSwap = nums[infPt - 1];
            int min = Integer.MAX_VALUE;
            for (int j = infPt; j <= n; j++) {
                if ((nums[j] - toSwap) > 0 && (nums[j] - toSwap) < min) {
                    // swap nums[j] and nums[infPt-1]
                    int temp = nums[j];
                    nums[j] = nums[infPt - 1];
                    nums[infPt - 1] = temp;
                }
            }
        }
        // sort the array from inflexion point till end
        Arrays.sort(nums, infPt, nums.length);
    }
}
