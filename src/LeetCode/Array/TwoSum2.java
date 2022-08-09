package LeetCode.Array;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        int[] ans = twoSum(arr, 6);
        System.out.println(Arrays.toString(ans));
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ans[0] = ++l;
                ans[1] = ++r;
                return ans;
            }
            else if (numbers[l] + numbers[r] > target) {
                r--;
            }
            else {
                l++;
            }
        }
        return ans;
    }
}
