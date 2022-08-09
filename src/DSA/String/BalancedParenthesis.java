package DSA.String;

import java.util.Stack;

public class BalancedParenthesis {
    
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (st.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) {
                return false;
            }
            
            else if (ch == '(' || ch == '{' || ch == '[') {
                st.add(ch);
            }
            
            else if (ch == ')' && st.peek() == '(') {
                st.pop();
            }
            
            else if (ch == '}' && st.peek() == '{') {
                st.pop();
            }
            
            else if (ch == ']' && st.peek() == '[') {
                st.pop();
            }
            
            else {
                st.push(ch);
            }
        }
        
        return st.isEmpty();
    }
}
