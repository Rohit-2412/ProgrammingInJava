// 12-08-2022 21:20 August

package Concepts.Sorting;

import Utility.FillArray;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[]arr = FillArray.fill(10);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int currentElement = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentElement;
            
        }
    }
    
}
