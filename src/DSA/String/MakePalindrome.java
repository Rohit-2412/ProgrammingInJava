package DSA.String;

/*
Minimum characters to be added at front to make string palindrome.

Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
Examples:


Input  : str = "ABC"
Output : 2
We can make above string palindrome as "CBABC"
by adding 'B' and 'C' at front.

Input  : str = "AACECAAAA";
Output : 2
We can make above string palindrome as AAAACECAAAA
by adding two A's at front of string.
 */

// https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/

/*
Efficient approach: We can solve this problem efficiently in O(n) time using lps array of KMP algorithm.
First we concat string by concatenating given string, a special character and reverse of given string then we will
get lps array for this concatenated string, recall that each index of lps array represent longest proper prefix which
 is also suffix. We can use this lps array for solving the problem.
 

For string = AACECAAAA
Concatenated String = AACECAAAA$AAAACECAA
LPS array will be {0, 1, 0, 0, 0, 1, 2, 2, 2,
                   0, 1, 2, 2, 2, 3, 4, 5, 6, 7}
Here we are only interested in the last value of this lps array because it shows us the largest suffix of the
reversed string that matches the prefix of the original string i.e these many characters already satisfy the
palindrome property. Finally, minimum number of character needed to make the string a palindrome is length of the
input string minus last entry of our lps array.
 */
public class MakePalindrome {
    
    public static void main(String[] args) {
        System.out.println(getMinChar("AAABC"));
    }
    
    public static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        lps[0] = 0; // lps[0] is always 0
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    
                    // Also, note that we do not increment
                    // i here
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    // Method returns minimum character to be added at
// front to make string palindrome
    static int getMinChar(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str);
        
        // Get concatenation of string, special character
        // and reverse string
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);
        
        // Get LPS array of this concatenated string
        int[] lps = computeLPSArray(s.toString());
        return str.length() - lps[s.length() - 1];
    }
    
}
