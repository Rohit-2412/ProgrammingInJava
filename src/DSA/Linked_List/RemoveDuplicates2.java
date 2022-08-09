package DSA.Linked_List;

import java.util.HashSet;

/*
Remove duplicates from an unsorted linked list
Easy Accuracy: 49.19% Submissions: 100k+ Points: 2
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List.
When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be
 removed.

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4
Example 2:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2
Explanation:Given linked list elements are
2->2->2->2->2, in which 2 is repeated. So,
we will delete the extra repeated elements
2 from the linked list and the resultant
linked list will contain only 2.
 */
public class RemoveDuplicates2 {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 7, 9, 2, 3, 4, 5, 6, 4, 5, 7, 8, 3, 5, 6, 9, 6, 4, 3};
        Node list = Node.create(arr);
        Node.print(removeDuplicates(list));
    }
    
    public static Node removeDuplicates(Node head) {
        Node ptr = head;
        HashSet<Integer> list = new HashSet<>();
        
        list.add(ptr.data);
        while (ptr.next != null) {
            
            if (!list.contains(ptr.next.data)) {
                list.add(ptr.next.data);
                ptr = ptr.next;
            }
            
            else {
                ptr.next = ptr.next.next;
            }
        }
        
        return head;
    }
    
}
