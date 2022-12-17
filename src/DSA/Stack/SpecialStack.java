// 09-10-2022 16:20 October

package DSA.Stack;

import java.util.Stack;

public class SpecialStack {
    public static void main(String[] args) {
    
    }
    
    static class specialStack {
        Stack<Integer> s;
        int mini;
        
        public specialStack() {
            this.s = new Stack<>();
        }
        
        void push(int x) {
            if (s.isEmpty()) {
                s.push(x);
                mini = x;
            }
            
            else {
                if (x < mini) {
                    s.add(2 * x - mini);
                    mini = x;
                }
                else {
                    s.push(x);
                }
            }
        }
        
        int pop() {
            if (s.isEmpty()) {
                return -1;
            }
            
            else {
                int curr = s.pop();
                if (curr > mini) {
                    return curr;
                }
                else {
                    int prevMin = mini;
                    mini = 2 * mini - curr;
                    
                    return prevMin;
                }
            }
        }
        
        int peek() {
            if (s.isEmpty()) return -1;
            
            int curr = s.peek();
            return Math.max(curr, mini);
        }
        
        boolean isEmpty() {
            return s.isEmpty();
        }
        
        int getMin() {
            if (s.isEmpty()) return -1;
            
            
            return mini;
        }
    }
}
