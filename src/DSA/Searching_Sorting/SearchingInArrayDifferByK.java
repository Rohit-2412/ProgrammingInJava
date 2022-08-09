package DSA.Searching_Sorting;

/*
A step array is an array of integers where each element has a difference of at most k with its neighbor. Given a key
x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
Examples:


Input : arr[] = {4, 5, 6, 7, 6}
           k = 1
           x = 6
Output : 2
The first index of 6 is 2.

Input : arr[] = {20, 40, 50, 70, 70, 60}
          k = 20
          x = 60
Output : 5
The index of 60 is 5
 */
public class SearchingInArrayDifferByK {
    // method 1
    // use linear search
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7, 6};
        System.out.println(search(arr, 1, 6));
    }
    
    // method 2
    // optimized approach : binary search
    static int search(int[] arr, int k, int key) {
        // find the diff between the leftmost element ( first element of array and the key)
        // if this value is greater shift the idx by diff/k instead of 1
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == key) {
                return i;
            }
            i += Math.max(1, Math.abs(arr[i] - key) / k);
            System.out.println("i : " + Math.abs(arr[i] - key) / k);
        }
        return -1;
    }
}
