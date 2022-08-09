package DSA.String;

/*
Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any
character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no.
 of operations required for transformation.

Input:  A = "ABD", B = "BAD"
Output: 1
Explanation: Pick B and insert it at front.

Input:  A = "EACBD", B = "EABCD"
Output: 3
Explanation: Pick B and insert at front, EACBD => BEACD
             Pick A and insert at front, BEACD => ABECD
             Pick E and insert at front, ABECD => EABCD
 */
public class TransformOneToAnother {
    /*
    1) Find if A can be transformed to B or not by first creating a count array for all characters of A, then
    checking with B if B has same count for every character.
2) Initialize result as 0.
3) Start traversing from end of both strings.
……a) If current characters of A and B match, i.e., A[i] == B[j]
………then do i = i-1 and j = j-1
    b) If current characters don’t match, then search B[j] in remaining
………A. While searching, keep incrementing result as these characters
………must be moved ahead for A to B transformation.
     */
    static int minOperations(String a, String b) {
        int[] count = new int[256];
        for (char c : a.toCharArray()) {
            count[c]++;
        }
        
        for (char c : b.toCharArray()) {
            count[c]--;
        }
        
        for (int j : count) {
            if (j != 0) return -1;
        }
        
        int res = 0;
        int i = a.length() - 1, j = b.length() - 1;
        
        while (i >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                res++;
            }
            else {
                j--;
            }
            i--;
        }
        
        return -1;
    }
    
}
