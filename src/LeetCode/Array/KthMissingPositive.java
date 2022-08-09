package LeetCode.Array;

public class KthMissingPositive {
    public static void main(String[] args) {
    
    }
    
    public static int findKthPositive(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else if (arr[mid] == target) {
                return arr[mid];
            }
        }
        return arr[start];
    }
}
