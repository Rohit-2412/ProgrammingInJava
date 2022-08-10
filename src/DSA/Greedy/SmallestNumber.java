// 10-08-2022 14:42 August
/*
Smallest number
MediumAccuracy: 50.0%Submissions: 16930Points: 4
The task is to find the smallest number with given sum of digits as S and number of digits as D.



Example 1:

Input:
S = 9
D = 2
Output:
18
Explanation:
18 is the smallest number
possible with sum = 9
and total digits = 2.


Example 2:

Input:
S = 20
D = 3
Output:
299
Explanation:
299 is the smallest number
possible with sum = 20
and total digits = 3.
 */

package DSA.Greedy;

public class SmallestNumber {
    public static void main(String[] args) {
        System.out.println(smallestNumber(20, 8));
    }
    
    static String smallestNumber(int s, int d) {
        StringBuilder ans = new StringBuilder();
        if (9 * d < s) return "-1";
        
        for (int i = d - 1; i >= 0; i--) {
            // if sum is greater than 9 then add 9
            if (s > 9) {
                ans.insert(0, 9);
                s -= 9; // subtracting 9 from sum
            }
            
            // if sum is less than 9
            else {
                // if this is the last digit to be added then add as it is
                if (i == 0) {
                    ans.insert(0, s);
                }
                
                // if there are more digits to be added
                else {
                    // add one less than required sum
                    ans.insert(0, s - 1);
                    i--; // decrement i
                    
                    // until i is not becoming 0 keep adding 0
                    while (i > 0) {
                        ans.insert(0, 0);
                        i--;
                    }
                    
                    // add one final 1 to have some effect of 0's
                    ans.insert(0, 1);
                    break;
                }
            }
        }
        return ans.toString();
    }
}