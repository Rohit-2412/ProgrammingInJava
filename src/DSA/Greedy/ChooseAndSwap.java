// 07-07-2022 18:57 July
/*
You are given a string s of lower case english alphabets. You can choose any two characters in the string and replace
 all the occurrences of the first character with the second character and replace all the occurrences of the second
 character with the first character. Your aim is to find lexicographically the smallest string that can be obtained
 by doing this operation at most once.

Example 1:

Input:
A = "ccad"
Output: "aacd"
Explanation:
In ccad, we choose a and c and after
doing the replacement operation once we get,
aacd and this is the lexicographically
the smallest string possible.
 */

package DSA.Greedy;

import java.util.TreeSet;

public class ChooseAndSwap {
    
    public static void main(String[] args) {
        System.out.println(chooseAndSwap("mnopqrta"));
    }
    
    static String chooseAndSwap(String a) {
        TreeSet<Character> set = new TreeSet<>();
        StringBuilder ans = new StringBuilder(a);
        for (char c : a.toCharArray()) set.add(c);
        
        for (int i = 0; i < ans.length(); i++) {
            char c1 = ans.charAt(i), c2;
            set.remove(c1);
            if(set.isEmpty()) break;
            System.out.println(set);
            c2 = set.toString().charAt(1);
            
            if(c2<c1)
            {
                for (int j = 0; j < ans.length(); j++) {
                    if(ans.charAt(j) == c1) {
                        ans.setCharAt(j,c2);
                    }
                    else if(ans.charAt(j) == c2)
                        ans.setCharAt(j,c1);
                }
                break;
            }
        }
        
        return ans.toString();
    }
    
    
}
