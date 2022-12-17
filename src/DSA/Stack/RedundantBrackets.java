// 09-10-2022 00:26 October

package DSA.Stack;

import java.util.Stack;

public class RedundantBrackets {
    public static void main(String[] args) {
        String s = "((a+b))";
        System.out.println(isRedundant(s));
    }
    
    
    static boolean isRedundant(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                stack.push(c);
            }
            else {
                if (c == ')') {
                    boolean flag = true;
                    while (stack.peek() != '(') {
                        char top = stack.pop();
                        
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            flag = false;
                        }
                    }
                    if (flag) return true;
                    stack.pop();
                }
            }
        }
        
        return false;
    }
}
