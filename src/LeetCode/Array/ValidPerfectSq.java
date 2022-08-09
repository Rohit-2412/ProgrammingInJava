package LeetCode.Array;

public class ValidPerfectSq {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2000105819));
    }
    
    public static boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        long mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid > num) {
                high = mid - 1;
            }
            else if (mid * mid < num) {
                low = mid + 1;
            }
            else if (mid == num / mid) {
                return true;
            }
        }
        return false;
    }
    
}
