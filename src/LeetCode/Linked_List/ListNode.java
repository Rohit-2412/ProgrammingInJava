package LeetCode.Linked_List;

public class ListNode {
    public int val;
    public ListNode next;
    
    ListNode() {}
    
    ListNode(int val) {this.val = val;}
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current_node = head;
        
        while (current_node != null) {
            ListNode next_node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node.next = next_node;
        }
        return prev;
    }
}
