package Concepts.Sorting;

import Utility.FillArray;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(7);
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
//        System.out.println("i = " + i);
//        System.out.println("pivot = " + pivot);
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
//                System.out.println(Arrays.toString(arr));
                
                // swapping elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
//                System.out.println("After swapping");
//                System.out.println(Arrays.toString(arr));
//
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
//        System.out.println(Arrays.toString(arr) + "\n");
        return i + 1;
    }
    
    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            sort(arr, l, pi - 1);
            sort(arr, pi + 1, r);
        }
    }
}
