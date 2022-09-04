package DSA.Searching_Sorting;

public class PainterPartition {
    public static int findPainters(int[] a, int n, int m) {
        int min = 0, max = 0;
        for (int i : a) {
            max += i;
            min = Math.max(i, min);
        }
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int need = 1, curr = 0;
            for (int i : a) {
                if (curr + i > mid) {
                    need++;
                    curr = 0;
                }
                curr += i;
            }
            if (need > m) {
                min = mid + 1;
            }
            
            else {
                max = mid - 1;
            }
        }
        return min;
    }
}
