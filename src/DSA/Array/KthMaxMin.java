package DSA.Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 5, 6, 6, 4, 1};
        int k = 1;
        System.out.println(KthMax(arr, k));
        System.out.println(KthMin(arr, k));
    }
    
    private static int KthMin(int[] arr, int k) {
        PriorityQueue<Object> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return (int) heap.poll();
    }
    
    private static int KthMax(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // minheap by default
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.poll();
    }
}
