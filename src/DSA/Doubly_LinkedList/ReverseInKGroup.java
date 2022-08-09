package DSA.Doubly_LinkedList;

import Utility.FillArray;

/*Reverse a doubly linked list in groups of given size
Difficulty Level : Medium
Last Updated : 23 Mar, 2022
Given a doubly linked list containing n nodes. The problem is to reverse every group of k nodes in the list.
 */
public class ReverseInKGroup {
    public static void main(String[] args) {
        int[] a = FillArray.fill(9, 11);
        Node.print(Node.create(a));
        Node.print(revInGroup(Node.create(a), 3));
    }
    
    /*
    Approach: Create a recursive function say reverse(head, k). This function receives the head or the first node of
    each group of k nodes. It reverses those group of k nodes by applying the approach discussed in Reverse a doubly
    linked list | Set-2. After reversing the group of k nodes the function checks whether next group of nodes exists
    in the list or not. If group exists then it makes a recursive call to itself with the first node of the next
    group and makes the necessary adjustments with the next and previous links of that group. Finally, it returns the
    new head node of the reversed group.
     */
    static Node revInGroup(Node head, int k) {
        Node curr = head;
        Node next = null;
        Node newHead = null;
        int count = 0;
        
        while (curr != null && count++ < k) {
            next = curr.next;
            newHead = push(newHead, curr);
            curr = next;
        }
        
        if (next != null) {
            head.next = revInGroup(next, k);
            head.next.prev = head;
            Node.print(head);
        }
        
        // pointer to new head of the Reversed DLL
        return newHead;
    }
    
    // function to insert a node at the beginning
    // of the Doubly Linked List
    private static Node push(Node head, Node newNode) {
        // prev of first node is always null
        newNode.prev = null;
        
        newNode.next = head;
        
        if (head != null) {
            head.prev = newNode;
        }
        
        head = newNode;
        return head;
    }
}
