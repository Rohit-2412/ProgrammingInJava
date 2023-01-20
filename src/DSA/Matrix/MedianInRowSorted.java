// Find median in a row wise sorted matrix

import java.util.Arrays;

//Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.
public class MedianInRowSorted {

    static int median(int[][] m, int r, int c) {
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            // Finding the minimum element
            low = Math.min(low, m[i][0]);

            // Finding the maximum element
            high = Math.max(high, m[i][c - 1]);
        }

        int desired = (r * c + 1) / 2;
        while (low < high) {
            int mid = low + (high - low) / 2;

            int place = 0;
            int get = 0;

            // Find count of elements smaller than mid
            for (int i = 0; i < r; ++i) {

                get = Arrays.binarySearch(m[i], mid);

                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if (get < 0) {
                    get = Math.abs(get) - 1;
                }

                // If element is found in the array it returns
                // the index(any index in case of duplicate). So we go to last
                // index of element which will give the number of
                // elements smaller than the number including
                // the searched element.
                else {
                    while (get < m[i].length && m[i][get] == mid)
                        get++;
                }

                place = place + get;
            }

            if (place < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // main function

    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        System.out.println(median(arr, arr.length, arr[0].length));

    }
}
