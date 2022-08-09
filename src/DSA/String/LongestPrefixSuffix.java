package DSA.String;

/*
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
 */
public class LongestPrefixSuffix {
    static int lps(String s) {
        int n = s.length();
        int[] lp = new int[n];
        
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lp[i] = len;
                i++;
            }
            else {
                if (len == 0) {
                    lp[i] = 0;
                    i++;
                }
                else {
                    len = lp[len - 1];
                }
            }
        }
        return len;
    }
}
