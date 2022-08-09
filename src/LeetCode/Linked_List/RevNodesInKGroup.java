package LeetCode.Linked_List;

public class RevNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode start = head, end = head;
        int idx = k - 1;
        while (idx-- != 0) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }
//       k = 3
//       1->2->3->4->5->6
        ListNode tempHead = reverseKGroup(end.next, k);
        reverse(start, end);
        start.next = tempHead;
        return end;
    }
    
    public void reverse(ListNode st, ListNode end) {
        ListNode prev = null;
        ListNode curr = st;
        ListNode next = st.next;
        
        while (prev != end) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
    }
}
