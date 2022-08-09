package DSA.Array;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int N = 4, M = 5;
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        merge(arr1, arr2, N, M);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
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
/*
    
    static int[] merge(int[] arr1, int n, int[] arr2, int m) {
        int[] merged_array = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged_array[k++] = arr1[i++];
            }
            else {
                merged_array[k++] = arr2[j++];
            }
        }
        while (i < n) {
            merged_array[k++] = arr1[i++];
        }
        while (j < m) {
            merged_array[k++] = arr2[j++];
        }
        return merged_array;
    }
*/

