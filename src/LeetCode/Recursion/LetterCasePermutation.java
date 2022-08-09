package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> result;
    
    public static void permuteLetters(String s, String currString, int idx) {
        if (currString.length() == s.length()) {
            result.add(currString);
        }
        else {
            // current character
            char ch = s.charAt(idx);
            // if current character is a digit then add as it is
            if (Character.isDigit(ch)) {
                permuteLetters(s, currString + ch, idx + 1);
            }
            else {
                // make it lower case and add to new string
                char newCh1 = Character.toLowerCase(ch);
                permuteLetters(s, currString + newCh1, idx + 1);
                // make it upper case and add to new string
                char newCh2 = Character.toUpperCase(ch);
                permuteLetters(s, currString + newCh2, idx + 1);
            }
        }
    }
    
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        permuteLetters(s, "", 0);
        return result;
    }
}
