package Questions;

import java.util.Stack;

// public class
public class StackProgram {
    public static void main(String[] args) {
        // declaring three empty stacks
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        // adding [6,4,9] in stack1 one by one
        stack1.add(6);
        stack1.add(4);
        stack1.add(9);
        
        // adding [1,2,3] in stack2 one by one
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        
        // calculating answer by multiplying top element from stack1 with top element from stack2
        int result = stack1.pop() * stack2.pop();
        stack3.add(result); // adding obtained result
        
        // calculating answer by dividing top element from stack1 with top element from stack2
        result = stack1.pop() / stack2.pop();
        stack3.add(result); // adding obtained result
        
        // printing all the stacks
        System.out.println("stack1 = " + stack1);
        System.out.println("stack2 = " + stack2);
        System.out.println("stack3 = " + stack3);
        
        // initializing maximum number with the lowest possible value
        int maxNumber = Integer.MIN_VALUE;
        // iterating over stack for finding maximum number
        for (int i : stack3)
            if (i > maxNumber) {
                maxNumber = i;
            }
        // printing maximum number from stack
        System.out.println("Maximum number from Stack3 is " + maxNumber);
    }
}
