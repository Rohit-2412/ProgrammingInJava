package Concepts.Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(int[] arr) {
        int idx = 0;
        while (idx < arr.length - 1) {
            while (arr[idx] != arr[arr[idx]])
                swap(arr, idx, arr[idx]);
            idx++;
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
