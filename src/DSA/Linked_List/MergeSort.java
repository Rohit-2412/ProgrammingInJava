package DSA.Linked_List;

/*
Merge Sort for Linked List
Medium Accuracy: 52.29% Submissions: 39049 Points: 4
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 4, 3, 2, 7, 8, 4, 1, 2, 5, 4, 0};
        Node l = Node.create(arr);
        Node.print(mergeSort(l));
        
    }
    
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node mid = slow;
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        head = merge(left, right);
        return head;
    }
    
    public static Node merge(Node a, Node b) {
        Node ans;
        if (a == null) return b;
        
        if (b == null) return a;
        
        if (a.data <= b.data) {
            ans = a;
            ans.next = merge(a.next, b);
        }
        
        else {
            ans = b;
            ans.next = merge(a, b.next);
        }
        
        return ans;
    }
    
    
}
