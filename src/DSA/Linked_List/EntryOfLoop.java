package DSA.Linked_List;

public class EntryOfLoop {
    public static Node Entry(Node head) {
        
        if(head==null || head.next==null)
            return null;
        
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (slow == fast) break;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
