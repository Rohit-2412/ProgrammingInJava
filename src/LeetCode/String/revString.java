package LeetCode.String;

import java.util.Arrays;

public class revString {
    public static void main(String[] args) {
        char[] arr = {'h', 'o', 'a', 's', 'd', 'f', 'b'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            // moving pointers
            l++;
            r--;
        }
    }
    
}
