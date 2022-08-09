package DSA.Searching_Sorting;

import java.util.Arrays;

import static Concepts.Sorting.CyclicSort.swap;

public class QuickSortOptimization {
    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 1, 2, 5, 4, 6, 9, 3, 10, 1, 4, 5, 7, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    // Trivial Quick sort
//    public static void quickSort(int[] arr, int l, int r) {
//        if (l < r) {
//            int pi = partition(arr, l, r);
//            quickSort(arr, l, pi - 1);
//            quickSort(arr, pi + 1, r);
//        }
//    }
//
//    public static int partition(int[] arr, int l, int r) {
//
//
//        int pivot = arr[r];
//
//        int i = l - 1;
//
//        for (int j = l; j < r; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                swap(arr, i, j);
//            }
//
//        }
//        swap(arr, i + 1, r);
//        return i + 1;
//    }
//
    // Quick sort using DNF Sort algorithm
    
    public static int compare(int num1, int num2) {
        return Integer.compare(num1, num2);
    }
    
/*
    public static Partition partition(int[] arr, int begin, int end) {
        int lt = begin, current = begin, gt = end;
        int partitioningValue = arr[begin];
        
        while (current <= gt) {
            
            int compareCurrent = (compare(arr[current], partitioningValue));
            
            switch (compareCurrent) {
                case -1 -> swap(arr, current++, lt++);
                case 0 -> current++;
                case 1 -> swap(arr, current, gt--);
            }
        }
        
        return new Partition(lt, gt);
    }
*/
    
    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        
        Partition middlePartition = partition(arr, begin, end);
        
        quickSort(arr, begin, middlePartition.getLeft() - 1);
        quickSort(arr, middlePartition.getRight() + 1, end);
    }
    
    public static Partition partition(int[] arr, int begin, int end) {
        
        int left = begin, right = end;
        int leftEqualKeysCount = 0, rightEqualKeysCount = 0;
        
        int partitioningValue = arr[end];
        
        while (true) {
            while (arr[left] < partitioningValue)
                left++;
            
            while (arr[right] > partitioningValue) {
                if (right == begin) {
                    break;
                }
                right--;
            }
            
            if (left == right && arr[left] == partitioningValue) {
                swap(arr, begin + leftEqualKeysCount, left);
                leftEqualKeysCount++;
                left++;
            }
            
            if (left >= right) {
                break;
            }
            
            swap(arr, left, right);
            
            if (arr[left] == partitioningValue) {
                swap(arr, begin + leftEqualKeysCount, left);
                leftEqualKeysCount++;
            }
            
            if (arr[right] == partitioningValue) {
                swap(arr, right, end - rightEqualKeysCount);
                rightEqualKeysCount++;
            }
            left++;
            right--;
        }
        right = left - 1;
        for (int k = begin; k < begin + leftEqualKeysCount; k++, right--) {
            if (right >= begin + leftEqualKeysCount) {
                swap(arr, k, right);
            }
        }
        for (int k = end; k > end - rightEqualKeysCount; k--, left++) {
            if (left <= end - rightEqualKeysCount) {
                swap(arr, left, k);
            }
        }
        return new Partition(right + 1, left - 1);
    }
    
    public static class Partition {
        private final int left;
        private final int right;
        
        public Partition(int left, int right) {
            this.left = left;
            this.right = right;
        }
        
        public int getLeft() {
            return left;
        }
        
        public int getRight() {
            return right;
        }
    }
}