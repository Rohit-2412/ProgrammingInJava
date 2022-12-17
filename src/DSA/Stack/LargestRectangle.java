// 09-10-2022 14:31 October

package DSA.Stack;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(height));
    }
    
    static int maxArea(int[] arr) {
        int n = arr.length;
        int area = Integer.MIN_VALUE;
        int[] next = nextSmallerElement(arr);
        int[] prev = prevSmallerElement(arr);
        
        for (int i = 0; i < n; i++) {
            int h = arr[i];
            if (next[i] == -1) next[i] = n;
            int b = next[i] - prev[i] - 1;
            
            int tempArea = h * b;
            area = Math.max(tempArea, area);
        }
        
        return area;
    }
    
    static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        stack.add(-1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int el = arr[i];
            
            while (stack.peek() != -1 && arr[stack.peek()] >= el)
                stack.pop();
            res[i] = stack.peek();
            stack.add(i);
        }
        
        return res;
    }
    
    static int[] prevSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        stack.add(-1);
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            
            while (stack.peek() != -1 && arr[stack.peek()] >= el)
                stack.pop();
            res[i] = stack.peek();
            stack.add(i);
        }
        
        return res;
    }
    
}
