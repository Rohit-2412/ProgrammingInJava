package DSA.String;

public class Palindrome {
    static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        int low = 0, high = str.length() - 1;
        
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
