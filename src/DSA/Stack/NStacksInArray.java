// 09-10-2022 16:02 October

package DSA.Stack;

import java.util.Arrays;

public class NStacksInArray {
    public static void main(String[] args) {
        nStack s = new nStack(4, 10);
        s.push(10, 1);
        s.push(11, 1);
        s.push(12, 1);
        
        s.push(111, 3);
        s.push(112, 3);
        s.push(113, 3);
        
        System.out.println(s.pop(1));
        System.out.println(s.pop(1));
        System.out.println(s.pop(1));
        
        System.out.println(s.pop(3));
        System.out.println(s.pop(3));
        System.out.println(s.pop(3));
    }
    
    static class nStack {
        int[] arr;
        int[] top;
        int[] next;
        
        int n, s;
        int freeSpot;
        
        // n = number of stacks
        public nStack(int n, int size) {
            s = size;
            this.n = n;
            
            this.arr = new int[size];
            
            this.top = new int[n];
            Arrays.fill(top, -1);
            
            this.next = new int[size];
            
            for (int i = 0; i < s; i++) {
                next[i] = i + 1;
            }
            next[next.length - 1] = -1;
            
            
            freeSpot = 0;
        }
        
        boolean push(int data, int stack) {
            if (freeSpot == -1) return false;
            
            // find index
            int index = freeSpot;
            
            // update free spot
            freeSpot = next[index];
            
            // push element
            arr[index] = data;
            
            // update next
            next[index] = top[stack - 1];
            
            // update top
            top[stack - 1] = index;
            
            return true;
        }
        
        int pop(int stack) {
            if (top[stack - 1] == -1) {
                return -1;
            }
            
            int index = top[stack - 1];
            
            top[stack - 1] = next[index];
            
            next[index] = freeSpot;
            
            freeSpot = index;
            
            return arr[index];
        }
    }
    
}
