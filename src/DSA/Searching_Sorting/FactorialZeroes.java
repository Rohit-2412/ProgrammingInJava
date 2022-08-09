package DSA.Searching_Sorting;

public class FactorialZeroes {
    public static void main(String[] args) {
        System.out.println(findNum(3));
    }
    
    public static int findNum(int n) {
        // 5! = 120 this the base case
        if (n == 1) return 5;
        
        int low = 0; int high = 5 * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (check(mid, n)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private static boolean check(int mid, int n) {
        int count = 0, f = 5;
        
        // dividing the number by 5
        // till the time the divisor is smaller
        while (f <= mid) {
            count += mid / f;
            f *= 5;
        }
        return (count >= n);
    }
}
