package LeetCode.Linked_List;

public class MiddleOfLL {
    public static void main(String[] args) {
    
    }
    
    public static int length(ListNode head) {
        int l = 0;
        if (head == null) {
            return l;
        }
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        return l;
    }
    
    public ListNode middleNode(ListNode head) {
        // using length of LL
//        int l = length(head);
//        ListNode ptr = head;
//        for (int i = 0; i < l / 2; i++) {
//            ptr = ptr.next;
//        }
//        return ptr;
        
//         method 2 using slow and fast
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
