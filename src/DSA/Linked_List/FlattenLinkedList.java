package DSA.Linked_List;

/*
Flattening a Linked List
Medium Accuracy: 33.91% Submissions: 81559 Points: 4
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.



Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     |
7     20    22   35
|           |     |
8          50    40
|                 |
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every
node in a single level.
(Note: | represents the bottom pointer.)
 */

public class FlattenLinkedList {
    public static void main(String[] args) {
    
    }
    
    static Node flatten(Node head) {
        if (head == null || head.bottom == null) return head;
        
        head.bottom = flatten(head.next);
        
        return merge(head, head.next);
    }
    
    static Node merge(Node a, Node b) {
        Node nn = new Node(0);
        Node temp = nn;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                b = b.bottom;
            }
            
            temp = temp.bottom;
            
            if (a == null) {
                temp.bottom = b;
            }
            
            else {
                temp.bottom = a;
            }
        }
        return nn.bottom;
    }
    
    static class Node {
        int data;
        Node bottom;
        Node next;
        
        Node(int d) {
            data = d;
            bottom = null;
            bottom = null;
        }
    }
}
