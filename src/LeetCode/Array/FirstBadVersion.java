package LeetCode.Array;

public class FirstBadVersion {
    public static void main(String[] args) {
    
    }
    
    public static boolean isBadVersion(int n) {
        return true;
    }
    
    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
