package DSA.Array;

public class CountInversion {
    public static void main(String[] args) {
        long[] arr = {468, 335, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 4, 8, 7, 5, 6, 7, 1, 170, 225, 479, 359,
                      463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437,
                      392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36,
                      395, 204, 312, 323};
        System.out.println(inversionCount(arr, arr.length));
        
    }
    
    static long inversionCount(long[] arr, long N) {
        int n = arr.length;
        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, (n - 1));
    }
    
    public static long mergeSort(long[] arr, long[] temp, int lb, int ub) {
        long inv_count = 0;
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            inv_count += mergeSort(arr, temp, lb, mid);
            inv_count += mergeSort(arr, temp, mid + 1, ub);
            inv_count += merge(arr, temp, lb, mid, ub);
        }
        return inv_count;
    }
    
    public static long merge(long[] arr, long[] temp, int lb, int mid, int ub) {
        long inv_count = 0;
        int i = lb, j = mid + 1, k = lb;
        
        while ((i <= mid) && (j <= ub)) if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        }
        else {
            temp[k++] = arr[j++];
            inv_count += (mid - i + 1);
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        
        while (j <= ub) temp[k++] = arr[j++];
        
        for (i = lb; i <= ub; i++)
            arr[i] = temp[i];
        
        return inv_count;
    }
}
