package DSA.String;

/*
Remove Consecutive Characters
Basic Accuracy: 55.83% Submissions: 13969 Points: 1
Given a string S delete the characters which are appearing more than once consecutively.

Example 1:

Input:
S = aabb
Output:  ab
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
Similiar explanation for b at
4th position.

Example 2:

Input:
S = aabaa
Output:  aba
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
'a' at fifth position is appearing
2nd time consecutively.
 */
public class AdjDuplicateRemoval {
    static StringBuilder sb;
    static int i = 0;
    
    public static void main(String[] args) {
        System.out.println(removeConsecutiveCharacter("aaaaaaaabbbcccc"));
    }
/*
    
    public static String removeConsecutiveCharacter(String s) {
        sb = new StringBuilder();
        int n = s.length();
        sb.append(s.charAt(0));
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) != s.charAt(j - 1)) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
    
*/
    
    // recursive approach
    
    public static String removeConsecutiveCharacter(String s) {
        String ans = "";
        // checking corner cases
        if (s.length() == 0 || s.length() == 1) return s;
        
        int i = 0;
        // checking for duplicates
        if (s.charAt(i) != s.charAt(i + 1)) {
            ans += s.charAt(0); // if not found then add the first character to Ans variable
        }
        ans += removeConsecutiveCharacter(s.substring(1)); // shrinking string by one character from left side
        return ans;
    }
    
}
