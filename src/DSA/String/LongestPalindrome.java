package DSA.String;

public class LongestPalindrome {
    
    
    static String print(String st, int i, int j) {
        return st.substring(i, j + 1);
    }
    
    static String longestPalindrome(String S) {
        int n = S.length();
        int end = 1, start = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1, h = i;
            while (l >= 0 && h < n && S.charAt(l) == S.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }
                l--;
                h++;
            }
            l = i - 1;
            h = i + 1;
            while (l >= 0 && h < n && S.charAt(l) == S.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }
                l--;
                h++;
            }
        }
        return print(S, start, start + end - 1);
        
    }
}
