// 09-10-2022 18:43 October

package DSA.Queue;

import java.util.Arrays;

public class NQueueInArray {
    
    static class nQueue {
        int n;
        int size;
        int[] arr;
        int[] front;
        int[] rear;
        int[] next;
        int freeSpot;
        
        public nQueue(int n, int size) {
            this.n = n;
            this.size = size;
            freeSpot = 0;
            this.arr = new int[size];
            this.next = new int[size];
            this.front = new int[n];
            this.rear = new int[n];
            Arrays.fill(front, -1);
            Arrays.fill(rear, -1);
            for (int i = 0; i < size; i++) {
                next[i] = i + 1;
            }
            next[size - 1] = -1;
        }
        
        void add(int data, int qn) {
            if (freeSpot == -1) System.out.println("No empty space");
            
            // find free index to store data
            int index = freeSpot;
            
            // check whether first element or not
            
            if (front[qn - 1] == -1) {
                front[qn - 1] = next[index];
            }
            else {
                next[rear[qn - 1]] = index;
            }
            
            // update next
            next[index] = -1;
            
            // update rear
            rear[qn - 1] = index;
            
            // push element
            arr[index] = data;
        }
        
        int pop(int qn) {
            if (front[qn - 1] == -1) {
                System.out.println("Underflow");
                return -1;
            }
            
            // index to pox
            int index = front[qn-1];
            
            // update front
            front[qn-1] = next[index];
            
            next[index] = freeSpot;
            
            freeSpot = index;
            
            return arr[index];
        }
    }
}
