package DSA.Doubly_LinkedList;

public class ReverseDLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node l = Node.create(arr);
        Node.print(l);
        Node.print(reverseDLL(l));
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
}
