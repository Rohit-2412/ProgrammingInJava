package DSA.Searching_Sorting;

import java.util.Arrays;

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
    
    }
    
    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        merge(arr1, arr2, arr1.length, arr2.length);
        if (k - 1 < arr1.length) {
            return arr1[k - 1];
        }
        else if (k - 1 == arr1.length) {
            return arr2[0];
        }
        else {
            return arr2[(k - arr1.length) - 1];
        }
    }
    
    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if ((arr1[i] > arr2[j])) {
                swap(arr1, i, arr2, j);
                i--;
            }
            else {
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
    
    private static void swap(int[] arr1, int i, int[] arr2, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
