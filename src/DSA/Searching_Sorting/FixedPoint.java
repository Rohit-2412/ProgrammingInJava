package DSA.Searching_Sorting;

import java.util.ArrayList;

/*
Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its
index value ( Consider 1-based indexing ).

Note: There can be more than one element in the array which have same valued as their index. You need to include every
 such element's index. Follows 1-based indexing of the array.
 */
public class FixedPoint {
    
    ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
