// 09-10-2022 00:14 October

package DSA.Stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(8);
        s.push(1);
        s.push(6);
        s.push(0);
        s.push(3);
        System.out.println(s);
        sort(s);
        System.out.println(s);
    }
    
    static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            sortedInsert(stack,top);
        }
    }
    
    private static void sortedInsert(Stack<Integer> stack,int top) {
        if(stack.isEmpty() || stack.peek() < top)
        {
            stack.push(top);
            return;
        }
        int t = stack.pop();
        sortedInsert(stack,top);
        stack.push(t);
    }
    
}
