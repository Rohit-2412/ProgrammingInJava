package DSA.Linked_List;

public class DeleteLoop {
    static Node slow = null;
    
    public static void removeLoop(Node head) {
        // checking is loop exists or not
        if (detectLoop(head)) {
            // let's say fast ptr = head
            Node fast = head;
            if (slow == head) // if both points to the head after loop detection
            // if slow == head
            // means cycle is present at the head
            {
                // moving the slow pointer towards the end of the list
                while (slow.next != fast) {
                    slow = slow.next;
                }
            }
            
            // if cycle is present at any other node then
            else {
                // moving pointers until their next value is same,
                // or we can say cycle point
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            // making next = null
            // so that cycle can be deleted
            slow.next = null;
        }
    }
    
    public static boolean detectLoop(Node head) {
        Node fast = head;
        slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (slow == fast) return true;
        }
        return false;
    }
}
