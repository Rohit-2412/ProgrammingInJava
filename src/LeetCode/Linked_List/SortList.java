package LeetCode.Linked_List;

public class SortList {
    public static void main(String[] args) {
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        // moving pointers to their location
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        // by the end of this loop
        // temp will be one behind the slow -> ending of first part of LL
        // slow will be at middle and fast will be at end of the list
        
        // now again dividing the list in 2 parts
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        
        return merge(left_side, right_side);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode sorted_temp = new ListNode(-1);
        ListNode current_node = sorted_temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current_node.next = l1;
                l1 = l1.next;
            }
            else {
                current_node.next = l2;
                l2 = l2.next;
            }
            current_node = current_node.next;
        }
        if (l1 != null) {
            current_node.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            current_node.next = l2;
            l2 = l2.next;
        }
        return sorted_temp.next;
    }
}
