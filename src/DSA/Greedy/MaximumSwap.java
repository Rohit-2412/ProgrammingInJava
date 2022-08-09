// 07-07-2022 19:59 July
/*
670. Maximum Swap
Medium

2592

148

Add to List

Share
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.



Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
 */

package DSA.Greedy;

public class MaximumSwap {
    
    public static void main(String[] args) {
        System.out.println(maximumSwap(1452));
    }
    
    public static int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] idx = new int[10];
        for (int i = 0; i < arr.length; i++) {
            idx[arr[i] - '0'] = i;
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j > arr[i] - '0'; j--) {
                if (idx[j] > i) {
                    char temp = arr[i];
                arr[i] = arr[idx[j]];
                arr[idx[j]] = temp;
                
                return Integer.parseInt(new String(arr));
                }
            }
        }
        
        return num;
    }
}
