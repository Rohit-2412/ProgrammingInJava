package DSA.Doubly_LinkedList;

import static java.lang.System.out;

public class Node {
    
    static Node head;
    public int data;
    public Node next, prev;
    
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public static Node create(int[] arr) {
        head = new Node(-1);
        
        for (int val : arr) {
            head.append(val);
        }
        return head.next;
    }
    
    public static void print(Node head) {
        Node ptr = head;
        while (ptr != null) {
            out.print(ptr.data + "<->");
            ptr = ptr.next;
        }
        out.println("null");
    }
    
    public static int length(Node head) {
        Node ptr = head;
        int len = 0;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        return len;
    }
    
    void append(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);
        
        Node last = head; /* used in step 5*/
        
        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;
        
        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        
        /* 5. Else traverse till the last node */
        while (last.next != null) last = last.next;
        
        /* 6. Change the next of last node */
        last.next = new_node;
        
        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }
    
    public static Node reverseDLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.prev = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public static Node reverseDLL(Node start,Node end) {
        Node prev = null;
        Node curr = start;
        Node next = null;
        
        while (curr != end) {
            next = curr.next;
            curr.prev = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
