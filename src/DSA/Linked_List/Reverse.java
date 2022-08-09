package DSA.Linked_List;

import static DSA.Linked_List.ListNode.create;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list = create(arr);
//        print(list);
//        list = reverse(list);
//        print(list);
    }
    
/*
    //     iterative way
    public static ListNode reverse(ListNode ptr) {
        ListNode nxt, curr, prev;
        nxt = null;
        curr = ptr;
        prev = null;
        
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = nxt;
        }
        
        ptr = prev;
        return ptr;
    }
*/

/*

// recursive way
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode rest = reverse(head.next);
        
        head.next.next = head;
        
        head.next = null;
        
        return rest;
    }
*/
}
