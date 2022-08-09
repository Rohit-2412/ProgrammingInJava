package DSA.Linked_List;

/*
Nth node from end of linked list
Easy Accuracy: 46.6% Submissions: 100k+ Points: 2
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the
linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list, and we need
to find 2nd node from end. 2nd node
from end os 8.
Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
 */
public class NthNodeFromEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node l = Node.create(arr);
        Node.print(l);
        System.out.println(getNthFromLast(l, 1));
    }
    
    static int getNthFromLast(Node head, int n) {
        Node dummy = head;
        int l = 0;
        while (dummy != null) {
            l++;
            dummy = dummy.next;
        }
        
        int idx = l - n;
        if (l - n >= 0) {
            while (head != null && head.next != null && idx-- != 0) {
                head = head.next;
            }
            return head.data;
        }
        else {
            return -1;
        }
    }
}
