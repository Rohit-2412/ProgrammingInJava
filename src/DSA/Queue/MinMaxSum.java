// 09-10-2022 19:56 October

package DSA.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxSum {
    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(arr, 4));
    }
    
    static int solve(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> maxi = new ArrayDeque<>();
        Deque<Integer> mini = new ArrayDeque<>();
        
        for (int i = 0; i < k; i++) {
            while (!maxi.isEmpty() && arr[maxi.peek()] <= arr[i]) {
                maxi.poll();
            }
            while (!mini.isEmpty() && arr[mini.peek()] >= arr[i]) {
                mini.poll();
            }
            
            maxi.add(i);
            mini.add(i);
            
        }
        
        int ans = 0;
        
        for (int i = k; i < n; i++) {
            ans += arr[maxi.peek()] + arr[mini.peek()];
            
            // removal
            while (!maxi.isEmpty() && i - maxi.peek() >= k) {
                maxi.pollFirst();
            }
            while (!mini.isEmpty() && i - mini.peek() >= k) {
                mini.pollFirst();
            }
            
            // addition
            while (!maxi.isEmpty() && arr[maxi.peek()] <= arr[i]) {
                maxi.poll();
            }
            while (!mini.isEmpty() && arr[mini.peek()] >= arr[i]) {
                mini.poll();
            }
            
            maxi.add(i);
            mini.add(i);
        }
        ans += arr[maxi.peek()] + arr[mini.peek()];
        
        return ans;
    }
    
}
