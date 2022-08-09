package Concepts.Binary_Search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
/*
//        given a sorted array we have to find the index of target value
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            arr.add(i * 5 + 20 % i + 5);
        }
//        [10, 15, 22, 25, 30, 37, 46, 49, 52, 55, 69, 73, 77, 81, 85]
        System.out.println(BS(arr, 10));
        System.out.println(BS(arr, 52));
        System.out.println(BS(arr, 81));
        System.out.println(BS(arr, 77));
        System.out.println(arr);
*/
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 50;
        System.out.println(binarySearch(arr, target));
    }
    
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
    
    static int BS(ArrayList<Integer> arr, int key) {
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        
        while (start <= end) {
//            mid = (l + r) / 2; // it might fail in some cases better to use second way
            mid = start + (end - start) / 2;
            if (arr.get(mid) == key) {
                return mid;
            }
            else if (arr.get(mid) > key) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
