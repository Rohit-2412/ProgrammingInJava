// 08-10-2022 22:55 October

package DSA.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
    String s = "{}{}{}{}()()([[[]]])";
        System.out.println(isBalanced(s));
    }
    
    static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            }
            else {
                if (!stack.isEmpty()) {
                    char t = stack.peek();
                    if ((c == ']' && t == '[') || (c == ')' && t == '(') || (c == '}' && t == '{')) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
    
        return stack.isEmpty();
    }
}
