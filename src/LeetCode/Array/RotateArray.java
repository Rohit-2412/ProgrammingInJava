package LeetCode.Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(num));
        rotate(num, 3);
        System.out.println(Arrays.toString(num));
        
    }
    
    public static void rotate(int[] arr, int k) {
        k = k % (arr.length);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            
            l++;
            r--;
        }
        l = 0;
        r = k - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        l = k;
        r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
