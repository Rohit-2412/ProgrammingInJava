package DSA.Searching_Sorting;

import java.util.Scanner;

public class BookAllocation {
    /*
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); int t; t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n, m; n = s.nextInt(); m = s.nextInt();
            int[] arr = new int[n];
            for (int index = 0; index < n; index++) {
                arr[i] = s.nextInt();
            }
            System.out.println(findPages(arr, n, m));
        }
    }

    public static boolean isPossible(int[] arr, int n, int m, int pages) {
        int student = 1, sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > pages) {
                return false; // if number of pages is more than required then return false
            }
            // if after considering the previous number of pages
            // sum becomes high then, we need to add one more student for allocation of pages
            if (sum + arr[i] > pages) {
                student++; sum = arr[i];
            }

            if (student > m) {
                return false;
            }

            // this means that we haven't reached he limits, so we can allot more books to that single student
            else {
                sum += arr[i];
            }
        } return true;
    }

    public static int findPages(int[] arr, int n, int m) {
        int sum = 0; if (n < m) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        } int start = 0; int end = sum; int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(arr, n, m, mid)) {
                ans = Math.min(ans, mid); end = mid - 1; // look for another smaller answer
            }

            else {
                start = mid + 1;
            }
        } return ans;
    }
*/
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); int t; t = s.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n, m; n = s.nextInt(); m = s.nextInt();
            int[] arr = new int[n];
            for (int index = 0; index < n; index++) {
                arr[i] = s.nextInt();
            }
            System.out.println(findPages(arr, n, m));
        }
    }
    
    public static int findPages(int[] arr, int n, int m) {
        int low = 0;
        int high = 0;
        // these variables are working like start and end of Binary Search
        for (int num : arr) {
            high += num; // sum of all books
            low = Math.max(num, low); // maximum number of pages
        }
        
        while (low <= high) {
            int mid = (low + high) >> 1; // right shift operator
            int need = 1; // number of students rwquired
            int curr = 0; // number of pages in current slot
            
            for (int i : arr) {
                if (curr + i > mid) {
                    need++;
                    curr = 0;
                }
                curr += i; // if number of pages is lower than mid then keep adding more
            }
            // if we need more students than required then we need to shift our boundaries
            // we will shift the lower boundary to mid+1
            // so that we can allocate more pages to one student
            if (need > m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}
