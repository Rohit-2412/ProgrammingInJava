package DSA.Linked_List;

/*
Delete nodes having greater value on right
Medium Accuracy: 37.92% Submissions: 58049 Points: 4
Given a singly linked list, remove all the nodes which have a greater value on their right side.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on the following nodes. So, after deleting
them, the linked list would like be 15,
11, 6, 3.
Example 2:

Input:
LinkedList = 10->20->30->40->50->60
Output: 60

 */
public class DeleteNode {
    public static void main(String[] args) {
        int[] arr = {12, 15, 10, 11, 5, 6, 2, 3};
        Node.print(compute(Node.create(arr)));
    }
    
    static Node compute(Node head) {
        if (head.next == null) return head;
        
        Node x = compute(head.next);
        
        if (head.data >= x.data) {
            head.next = x;
        }
        else {
            head = x;
        }
        
        return head;
    }
}
