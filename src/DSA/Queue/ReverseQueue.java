// 09-10-2022 16:58 October

package DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(4);
        q.add(2);
        q.add(8);
        q.add(20);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
    
    static void reverse(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            int front = queue.poll();
            reverse(queue);
            queue.add(front);
        }
    }
    
}
