// 09-10-2022 15:49 October

package DSA.Stack;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(maxArea(arr));
    }
    
    static int maxArea(int[][] arr) {
        
        int area = largestArea(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
                else {
                    arr[i][j] = 0;
                }
                area = Math.max(area, largestArea(arr[i]));
                
            }
        }
        return area;
    }
    
    static int largestArea(int[] arr) {
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
            
            while (stack.peek() != -1 && arr[stack.peek()] >= el) stack.pop();
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
            
            while (stack.peek() != -1 && arr[stack.peek()] >= el) stack.pop();
            res[i] = stack.peek();
            stack.add(i);
        }
        
        return res;
    }
}
