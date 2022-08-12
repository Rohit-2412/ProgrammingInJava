package Concepts.Sorting;

import Utility.FillArray;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        
        int[] arr = FillArray.fill(12, 50);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void mergeSort(int[] arr, int l, int r) {
        
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            
            merge(arr, l, mid, r);
        }
    }
    
    private static void merge(int[] arr, int l, int mid, int r) {
        int len1 = mid - l + 1; // 0 based indexing
        int len2 = r - mid;
        int[] a = new int[len1];
        int[] b = new int[len2];
        
        System.arraycopy(arr, l, a, 0, len1);
        
        for (int i = 0; i < len2; i++) {
            b[i] = arr[mid + i + 1];
        }
        
        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            }
            else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        
        while (i < len1) {
            arr[k++] = a[i++];
        }
        
        while (j < len2) {
            arr[k++] = b[j++];
        }
    }
}
