package DSA.Searching_Sorting;

/*
Arithmetic Number
Easy Accuracy: 48.05% Submissions: 50742 Points: 2
Given three integers  'A' denoting the first term of an arithmetic sequence , 'C' denoting the common difference of
an arithmetic sequence and an integer 'B'. you need to tell whether 'B' exists in the arithmetic sequence or not.

Example 1:

Input: A = 1, B = 3, C = 2
Output: 1
Explanation: 3 is the second term of the
sequence starting with 1 and having a common
difference 2.
Example 2:

Input: A = 1, B = 2, C = 3
Output: 0
Explanation: 2 is not present in the sequence.
 */
public class MissingNumberInAP {
    public static void main(String[] args) {
        System.out.println(inSequence(1,545,78));
    }
    
    static int inSequence(int a, int b, int c) {
        if (c == 0) {
            if (a == b) return 1;
            return 0;
        }
        else if (a == b) {
            return 1;
        }
        else if ((b > a && c > 0) && ((b - a) % c == 0)) {
            return 1;
        }
        else if ((b < a && c < 0) && (b - a) % c == 0) {
            return 1;
        }
        return 0;
    }
}
