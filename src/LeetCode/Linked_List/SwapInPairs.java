package LeetCode.Linked_List;

public class SwapInPairs {
    public static void main(String[] args) {
    
    }
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head; // ans Node
        
        ListNode current = temp;
        while ((current.next != null) && (current.next.next != null))
        {
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;
            // swapping nodes
            first_node.next = second_node.next;
            current.next = second_node;
            current.next.next = first_node;
            current = current.next.next;
        }
        return temp.next;
    }
    }
