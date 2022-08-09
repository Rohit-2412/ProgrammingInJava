package DSA.Array;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 1};
        System.out.println(findDuplicate(arr));
    }
    
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length ) {
            if (nums[i] != i + 1) {
                int correct = nums[i] - 1;
                if (nums[i] != nums[correct]) {
                    swap(nums, i, correct);
                }
                else // we have found our answer
                {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }
        return -1;
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
