package LeetCode.Linked_List;

public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        while (l1 != null) {
            current_node.next = l1;
            l1 = l1.next;
            current_node = current_node.next;
        }
        while (l2 != null) {
            current_node.next = l2;
            l2 = l2.next;
            current_node = current_node.next;
        }
        return sorted_temp.next;
    }
}
