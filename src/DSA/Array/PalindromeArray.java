package DSA.Array;

public class PalindromeArray {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(123));
        int[] a = {121, 131, 20};
        System.out.println(palindromeArray(a, a.length));
    }
    
    public static int palindromeArray(int[] a, int n) {
        for (int num : a) {
            if (!isPalindrome(num)) {
                return 0;
            }
        }
        return 1;
    }
    
    private static boolean isPalindrome(int num) {
        StringBuilder s = new StringBuilder();
        s.append(num);
        int n = s.length() - 1;
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i)) {
                return false;
            }
        }
        return true;
    }
    
}
