package DSA.Searching_Sorting;

import java.util.Arrays;

/*

Find Missing And Repeating

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one
number 'B' occurs twice in array. Find these two numbers.

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2
 */
public class MissingAndRepeating {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
        
        
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int[] findTwoElement(int[] arr, int n) {
        int[] answer = new int[2];
        
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                swap(arr, arr[i], arr[arr[i] - 1]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                answer[0] = arr[i];
                answer[1] = i + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return answer;
    }
}
