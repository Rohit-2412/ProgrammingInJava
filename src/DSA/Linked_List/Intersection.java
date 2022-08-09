package DSA.Linked_List;

import Utility.FillArray;

import java.util.HashSet;

/*
Intersection of two sorted Linked lists
Easy Accuracy: 29.44% Submissions: 63267 Points: 2
Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new
 list should be made with its own memory — the original lists should not be changed.
Note: The list elements are not necessarily distinct.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
 */
public class Intersection {
    public static void main(String[] args) {
        int[] a = FillArray.fill(10);
        int[] b = FillArray.fill(14000);
        Node l1 = Node.create(a), l2 = Node.create(b);
        Node ans = intersection(l1, l2);
        Node.print(ans);
        
    }
    
    public static Node intersection(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node ans = dummy;
        HashSet<Integer> map = new HashSet<>();
        int l1 = Node.length(head1);
        int l2 = Node.length(head2);
        
        Node h1;
        Node h2;
        if (l1 > l2) {
            h1 = head1;
            h2 = head2;
        }
        else {
            h1 = head2;
            h2 = head1;
        }
        
        while (h1 != null) {
            map.add(h1.data);
            h1 = h1.next;
        }
        
        while (h2 != null) {
            if (map.contains(h2.data)) {
                ans.next = new Node(h2.data);
            }
            ans = ans.next;
            h2 = h2.next;
        }
        return dummy.next;
    }
}
