package LeetCode.Linked_List;

public class RemoveDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        // temporary node
        ListNode answer = new ListNode(0, head);
    
        // predecessor = the last node
        // before the sublist of duplicates
        ListNode prev = answer;
    
        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                prev.next = head.next;
                // otherwise, move predecessor
            } else {
                prev = prev.next;
            }
        
            // move forward
            head = head.next;
        }
        return answer.next;
    }
    }
