// 09-10-2022 00:55 October

package DSA.Stack;

import java.util.Stack;

public class MinimumCost {
    public static void main(String[] args) {
        String s = "}}}{{{";
//        }}}{{{
//        {}{}{}
        System.out.println(findCost(s));
    }
    
    static int findCost(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '{') {
                stack.add(c);
            }
            else {
                if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                    stack.pop();
                }
                else {
                    stack.add(c);
                }
            }
        }
        
        int open = 0, close = 0;
        for (Character c : stack) {
            if (c == '{') {
                open++;
            }
            else {
                close++;
            }
        }
        if (open % 2 != 0 && close % 2 == 0) {
            return -1;
        }
        
        if (open % 2 == 0 && close % 2 != 0) {
            return -1;
        }
        return (open + 1) / 2 + (close + 1) / 2;
    }
    
}
