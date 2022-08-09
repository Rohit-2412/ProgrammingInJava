package LeetCode.Array;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(123456));
    }
    
    public static int arrangeCoins(int n) {
//        int ans = 0;
//        for (int i = 1; i <= n; i++) {
//            if ((n - i) > 0) {
//                ans++;
//                n -= i;
//            }
//        }
//        return ans;
        
        // using binary search
        long left = 0, right = n - 1;
        long mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * (mid + 1) / 2 > n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (int) (left - 1);
    }
}
