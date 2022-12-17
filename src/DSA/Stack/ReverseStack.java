// 08-10-2022 23:51 October

package DSA.Stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < 6; i++) {
            s.push(i);
        }
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    
    static void reverse(Stack<Integer> stack)
    {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack);
            insert(stack,top);
        }
    }
    
    static void insert(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
        }
        else {
            int top = stack.pop();
            insert(stack, data);
            stack.push(top);
        }
    }
}
