package DSA.Searching_Sorting;

import java.util.Arrays;

import static Concepts.Sorting.CyclicSort.swap;

public class MergeSortInPlace {
    /*
//     Approach 1
//     using two pointers
//      TC : n^2 log(n)
        public static void main(String[] args) {
            int[] arr = {1, 7, 6, 5, 3, 1, 2, 9, 8, 7, 0, 3, 5};
            mergeSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
        
        public static void merge(int[] arr, int start, int mid, int end) {
            int start2 = mid + 1;
            
            if (arr[mid] <= arr[start2]) {
                return;
            }
            
            while (start <= mid && start2 <= end) {
                if (arr[start] <= arr[start2]) {
                    start++;
                }
                
                // arr[start] > arr[start2]
                else {
                    int val = arr[start2];
                    int idx = start2;
                    
                    while (idx != start) {
                        arr[idx] = arr[idx - 1];
                        idx--;
                    }
                    arr[start] = val;
                    
                    start++;
                    mid++;
                    start2++;
                }
            }
        }
        
        static void mergeSort(int[] arr, int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                
                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);
                
                merge(arr, l, m, r);
            }
        }
    */


// Approach 2
// using shell sort plus mergesort
    
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 9, 2, 4, 6, 11, 4, 7, 8, 5, 1, 0, 2, 5, 4, 1, 9, 7, 8, 9, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void mergeSort(int[] arr, int s, int e) {
        
        if (s == e) return;
        
        int mid = s + (e - s) / 2;
        
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, e);
        
        merge(arr, s, e);
    }
    
    private static void merge(int[] arr, int s, int e) {
        int gap = e - s + 1;
        
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = s; i + gap <= e; i++) {
                int j = i + gap;
                
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
    
    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (int) (Math.ceil(gap / 2.0));
    }
}
