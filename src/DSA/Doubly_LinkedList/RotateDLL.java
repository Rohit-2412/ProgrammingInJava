package DSA.Doubly_LinkedList;

public class RotateDLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node l = Node.create(arr);
        Node.print(l);
        Node.print(rotateDll(l, 2));
    }
    
    // 1 2 3 4 5 6 7 :: original
    // 7 1 2 3 4 5 6 :: 1st step
    // 6 7 1 2 3 4 5 :: 2nd step
    // 5 6 7 1 2 3 4 :: 3rd step
    // . . .
    
    static Node rotateByK(Node head, int k) {
        for (int i = 0; i < Node.length(head) - k; i++) {
            head = rotateLeft(head);
        }
        return head;
    }
    
    static Node rotateLeft(Node ptr) {
        Node prev = ptr;
        Node last = ptr.next;
        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        prev.next = null;
        last.prev = null;
        last.next = ptr;
        return last;
    }
    
    static Node rotateDll(Node head, int pos) {
        if (pos == 0) return head;
        
        Node current = head;
        
        while (pos-- != 0) {
            current = current.next;
        }
        
        Node tail = current.prev;
        Node newHead = current;
        tail.next = null;
        current.prev = null;
        
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = head;
        head.prev = current;
        head = newHead;
        
        return head;
    }
}

