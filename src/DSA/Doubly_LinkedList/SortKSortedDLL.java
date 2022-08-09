package DSA.Doubly_LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Sort a k sorted doubly linked list
        Difficulty Level : Hard
        Last Updated : 12 Apr, 2022
        Given a doubly linked list containing n nodes, where each node is at most k away from its target position in
        the list. The problem is to sort the given doubly linked list.
        For example, let us consider k is 2, a node at position 7 in the sorted doubly linked list, can be at
        positions 5, 6, 7, 8, 9 in the given doubly linked list.
*/
public class SortKSortedDLL {
    
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 12, 56, 8};
        Node l = Node.create(arr);
        Node.print(sort(l, 2));
        Node.print(sortDLL(l, 2));
    }
    
    //    Using Insertion Sort
//    Time Complexity: O(n*k)
//    Space Complexity: O(1)
    public static Node sort(Node head, int k) {
        
        for (Node i = head.next; i != null; i = i.next) {
            Node j = i;
            
            while (j.prev != null && j.data < j.prev.data) {
                // swap j and j.prev node
                Node temp = j.prev.prev;
                Node temp2 = j.prev;
                Node temp3 = j.next;
                
                j.prev.next = temp3;
                j.prev.prev = j;
                
                j.prev = temp;
                j.next = temp2;
                
                if (temp != null) {
                    temp.next = j;
                    
                }
                if (temp3 != null) {
                    temp3.prev = temp2;
                }
            }
            
            if (j.prev == null) {
                head = j;
            }
        }
        return head;
    }
    
    // Time Complexity: O(n*log k)
    // Auxiliary Space: O(k)
    public static Node sortDLL(Node head, int k) {
        if (head == null) return null;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        
        Node newHead = null, last = null;
        
        // creating min heap for first k elements
        for (int i = 0; head != null && i <= k; i++) {
            pq.add(head);
            head = head.next;
        }
        
        while (!pq.isEmpty()) {
            if (newHead == null) {
                newHead = pq.peek();
                newHead.prev = null;
                
                // last points to the last node of the resulted list so far
                last = newHead;
            }
            
            else {
                last.next = pq.peek();
                pq.peek().prev = last;
                
                last = pq.peek();
            }
            
            // popping node from pq
            pq.poll();
            
            if (head != null) {
                // adding next items if list is not null
                pq.add(head);
                
                head = head.next;
            }
        }
        
        if (last != null) {
            last.next = null;
        }
        
        return newHead;
    }
}
