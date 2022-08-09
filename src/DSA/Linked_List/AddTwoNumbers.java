package DSA.Linked_List;

/*
Add two numbers represented by linked lists
Easy Accuracy: 30.12% Submissions: 100k+ Points: 2
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.

The sum list is a linked list representation of the addition of two input numbers from the last.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 9, 0, 9};
        int[] arr2 = {1,1, 0, 3, 9, 0, 9};
        Node l1 = Node.create(arr1);
        Node l2 = Node.create(arr2);
        
        Node l3 = addTwoLists(l1, l2);
        Node.print(l3);
    }
    
    static Node addTwoLists(Node first, Node second) {
        Node ans = new Node(-1);
        Node dummy = ans;
        first = Node.reverse(first);
        second = Node.reverse(second);
        int carry = 0;
        while (first != null && second != null) {
            int val = first.data + second.data + carry;
            carry = val / 10;
            val %= 10;
            ans.next = new Node(val);
            
            first = first.next;
            second = second.next;
            ans = ans.next;
        }
        
        while (first != null) {
            int val = first.data + carry;
            ans.next = new Node(val);
            carry = val / 10;
            val %= 10;
            
            first = first.next;
            ans = ans.next;
        }
        
        while (second != null) {
            int val = second.data + carry;
            ans.next = new Node(val);
            carry = val / 10;
            val %= 10;
            
            second = second.next;
            ans = ans.next;
        }
        if (carry != 0) {
            ans.next = new Node(carry);
            ans = ans.next;
        }
        return Node.reverse(dummy.next);
    }
}
