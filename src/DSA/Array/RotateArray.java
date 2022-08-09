package DSA.Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 1;
        LeetCode.Array.RotateArray.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
