// 12-08-2022 21:20 August

package Concepts.Sorting;

import Utility.FillArray;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(5);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
