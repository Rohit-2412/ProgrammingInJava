// 05-10-2022 12:35 October

package Others;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 5, 6, 7, 2, 3, 9};
        kthMax(arr, 3);
    }
    
    static void kthMax(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : arr) {
            if (heap.size() >= k) {
                heap.poll();
            }
            heap.add(j);
        }
        System.out.println(heap);
        System.out.println(heap.poll());
    }
}