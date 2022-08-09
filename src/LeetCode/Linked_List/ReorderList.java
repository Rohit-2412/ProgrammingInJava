package LeetCode.Linked_List;

public class ReorderList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            
            if (l1_next == null) break;
            
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // reversing the second half of list
        ListNode l2 = reverse(slow);
        // merging the two halves of list in one List
        merge(l1, l2);
    }
}
