// 08-10-2022 22:45 October

package DSA.Stack;

import java.util.Stack;

public class MiddleElement {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 6; i++) {
            s.push(i);
        }
        System.out.println(s);
        middleElement(s);
        System.out.println(s);
    }
    
    static void middleElement(Stack<Integer> stack) {
        helper(stack, stack.size(), 0);
        
    }
    
    private static void helper(Stack<Integer> stack, int size, int count) {
        if (count == size / 2) {
            stack.pop();
            return;
        }
        int top = stack.pop();
        helper(stack, size, count + 1);
        stack.push(top);
    }
}
