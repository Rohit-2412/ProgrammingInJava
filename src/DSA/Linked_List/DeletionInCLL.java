package DSA.Linked_List;

public class DeletionInCLL {
    public static void main(String[] args) {
    
    }
    
    public static Node deletion(Node head, int val) {
        if (head == null) return null;
        Node prev = new Node();
        Node curr = head.next;
        
        while (curr.data != val) {
            if (curr.next == head) break;
            prev = curr;
            curr = curr.next;
        }
        
        // checking for multiple occurrences of node
        
        if (curr == head) {
            prev = head;
            
            while (prev.next != head) {
                prev = prev.next;
            }
            
            head = curr.next;
            prev.next = head;
        }
        
        // checking if node is last node
        else if (curr.next == head) {
            prev.next = head;
        }
        else {
            prev.next = curr.next;
        }
        return head;
        
    }
}
