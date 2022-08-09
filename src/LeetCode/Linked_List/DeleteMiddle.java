package LeetCode.Linked_List;

public class DeleteMiddle {
    public static void main(String[] args) {}
    
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
    
    public ListNode deleteMiddle(ListNode head) {
        int l = length(head);
        ListNode ptr = head;
        if (l == 1) {
            return ptr.next;
        }
        for (int i = 0; i < l; i++) {
            if (i == (l / 2) - 1) {
                ptr.next = ptr.next.next;
                break;
            }
            else {
                ptr = ptr.next;
            }
        }
        return head;
    }
}
