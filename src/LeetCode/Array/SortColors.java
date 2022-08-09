package LeetCode.Array;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {1,2, 0, 2, 1, 1, 0,1};
        sortColors(arr);
    }
    
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
    color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
     */
    public static void sortColors(int[] nums) {
        // we will ude dnf sort to sort the colors
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
