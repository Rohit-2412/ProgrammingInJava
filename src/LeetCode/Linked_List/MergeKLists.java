package LeetCode.Linked_List;

import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        // using min heap concept
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }
        return dummy.next;
    }
}
