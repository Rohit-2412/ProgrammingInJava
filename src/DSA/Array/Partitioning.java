package DSA.Array;

import java.util.Arrays;

//Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is
// divided into three parts.
//        1) All elements smaller than a come first.
//        2) All elements in range a to b come next.
//        3) All elements greater than b appear in the end.
//        The individual elements of three sets can appear in any order. You are required to return the modified array.
public class Partitioning {
    // Algorithm :  dnf sort
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 1, 3, 5, 7};
        System.out.println(Arrays.toString(arr));
        threeWayPartition(arr, 4, 6);
        System.out.println(Arrays.toString(arr));
    }
    
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    static void threeWayPartition(int[] arr, int a, int b) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] < a) {
                swap(arr, mid, low);
                mid++;
                low++;
            }
            else if (arr[mid] >= a && arr[mid] <= b) {
                mid++;
            }
            
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
}
