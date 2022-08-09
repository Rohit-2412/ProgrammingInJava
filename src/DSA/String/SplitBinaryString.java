package DSA.String;

/*
Split the binary string into substrings with equal number of 0s and 1s

Input: str = “0100110101”
Output: 4
The required substrings are “01”, “0011”, “01” and “01”.
Input: str = “0111100010”
Output: 3

Input: str = “0000000000”

Output: -1
 */
public class SplitBinaryString {
    public static void main(String[] args) {
        String s = "010";
        System.out.println(split(s));
    }
    
    /*
    Approach. First we will traverse the whole string. And maintain the count of zeros and ones we have reached so
    far. If at any point the count of zeros and ones became equal then we will increment our answer by 1.
    else return -1
     */
    static int split(String s) {
        int answer = 0;
        int count_0 = 0;
        int count_1 = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                count_0++;
            }
            
            else {
                count_1++;
            }
            
            if (count_1 == count_0) answer++;
        }
        return count_0 == count_1 ? answer : -1;
    }
}
