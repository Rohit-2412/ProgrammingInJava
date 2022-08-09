package LeetCode.Linked_List;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        
        ListNode slow = ans;
        ListNode fast = ans;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // deleting the node
        slow.next = slow.next.next;
        return ans.next;
    }
}
