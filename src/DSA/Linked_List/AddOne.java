package DSA.Linked_List;

public class AddOne {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9, 9, 9, 9, 9};
        Node l = Node.create(arr);
        Node.print(l);
        add(l);
        Node.print(l);
    }
    
    
    public static Node add(Node head) {
        Node curr = head, prev = head;
        while (curr != null) {
            if (curr.data < 9) {
                prev = curr;
            }
            curr = curr.next;
        }
        
        // all numbers are 9
        if (prev == head) {
            prev.data += 1;
            prev = prev.next;
        }
        
        while (prev != null) {
            prev.data = (prev.data + 1) % 10;
            prev = prev.next;
        }
        
        return head;
    }
}
