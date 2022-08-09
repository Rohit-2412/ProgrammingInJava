package DSA.Linked_List;

/*
Clone a linked list with next and random pointer
Hard Accuracy: 49.62% Submissions: 39343 Points: 8
You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You
are also given M random pointers, where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.

Construct a copy of the given list. The copy should consist of exactly N new nodes, where each new node has its value
 set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point
 to new nodes in the copied list such that the pointers in the original list and copied list represent the same list
 state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

Example 1:

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output: 1
Explanation: In this test case, there
are 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbitrary pointer
set, rest two nodes have arbitrary pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbitrary pointer is set to
node 2.  The second node arbitrary pointer
is set to node 4.
 */

public class CloneLL {
    public static void main(String[] args) {
//        copyList(Node.create(FillArray.fill(5)));
    }
    
    static Node copyList(Node head) {
        Node curr = head;
        Node temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        
        curr = head;
        
        while (curr != null) {
            curr.next.arb = curr.arb != null ? curr.arb.next : null;
            
            curr = curr.next.next;
        }
        
        Node original = head;
        Node copy = head.next;
        temp = copy; // for returning answer
        while (original != null && copy != null) {
            original.next = original.next.next;
            copy.next = copy.next != null ? copy.next.next : null;
            
            original = original.next;
            copy = copy.next;
        }
        
        return temp;
    }
    
    static class Node {
        int data;
        Node next, arb;
        
        Node(int d) {
            data = d;
            next = arb = null;
            
        }
    }
}
