package DSA.Linked_List;

public class CheckPalindrome {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 4, 3, 2, 1};
        Node l = Node.create(arr);
        System.out.println(isPalindrome(l));
    }
    
    static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        // getting middle of LL
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        
        fast = head;
        while (slow != null) {
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
