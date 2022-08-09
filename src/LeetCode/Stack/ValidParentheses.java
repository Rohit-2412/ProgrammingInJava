package LeetCode.Stack;

import java.util.Stack;
import java.lang.String;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{}{}{}[[{}]]"));
    }
    
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // if the string starts with the closing bracket return false
            if (st.empty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                return false;
            }
            else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') // opening bracket : direct push
            {
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && st.peek() == '(') // 3 cases of different closing brackets
            {
                st.pop();
            }
            else if (s.charAt(i) == '}' && st.peek() == '{') {
                st.pop();
            }
            else if (s.charAt(i) == ']' && st.peek() == '[') {
                st.pop();
            }
            else {
                st.push(s.charAt(i));
            }
        }
        return st.empty();
    }
}
