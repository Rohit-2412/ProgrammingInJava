package DSA.Searching_Sorting;

public class PivotInSortedRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(pivotElement(arr, 0, arr.length, 0, arr.length));
    }
    
    public static int pivotElement(int[] arr, int start, int end, int lowerBound, int upperBound) {
        int mid = start + (end - start) / 2;
        // extreme left case
        if (mid == lowerBound) {
            if (mid == upperBound) {
                return arr[mid];
            }
            else if (arr[mid] >= arr[mid + 1]) {
                return arr[mid];
            }
        }
        // extreme right case
        else if (mid == upperBound) {
            if (arr[mid] >= arr[mid - 1]) {
                return arr[mid];
            }
        }
        else {
            if (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]) {
//                mid is the pivot element
                return arr[mid];
            }
            // pivot lies in second half
            else if (arr[mid] > arr[end]) {
                pivotElement(arr, mid + 1, end, 0, arr.length);
            }
            // pivot lies in first half
            else {
                pivotElement(arr, start, mid - 1, 0, arr.length);
            }
        }
        return -1;
    }
}
