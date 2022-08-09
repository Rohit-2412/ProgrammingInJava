package DSA.Linked_List;

import static java.lang.System.out;

public class ListNode {
    public int val;
    public ListNode next;
    
    ListNode() { }
    
    ListNode(int val) { this.val = val; }
    
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
    
    public static int length(ListNode head) {
        ListNode ptr = head;
        
        int len = 0;
        while (ptr.next != null) {
            ptr = ptr.next;
            len++;
        }
        return len;
    }
    
    public static void print(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        out.println("null");
    }
    
    private static ListNode insert(ListNode root, int val) {
        ListNode temp = new ListNode(val);
        ListNode ptr = new ListNode();
        ptr.next = null;
        
        if (root == null) {
            root = temp;
        }
        
        else {
            ptr = root;
            while (ptr.next != null)
                ptr = ptr.next;
            
            ptr.next = temp;
        }
        
        return root;
    }
    
    public static ListNode create(int[] arr) {
        ListNode root = null;
        
        for (int j : arr) {
            root = insert(root, j);
        }
        
        return root;
    }
}