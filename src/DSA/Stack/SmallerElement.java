// 09-10-2022 14:32 October

package DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class SmallerElement {
    public static void main(String[] args) {
        int[] arr = {9, 7, 4, 6, 3, 2, 0, 1};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
        System.out.println(Arrays.toString(prevSmallerElement(arr)));
    }
    
    static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        stack.add(-1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int el = arr[i];
            
            while (stack.peek() >= el)
                stack.pop();
            res[i] = stack.peek();
            stack.add(el);
        }
        
        return res;
    }
    
    static int[] prevSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        stack.add(-1);
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            
            while (stack.peek() >= el)
                stack.pop();
            res[i] = stack.peek();
            stack.add(el);
        }
        
        return res;
    }
    
}
