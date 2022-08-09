package DSA.Linked_List;

import Utility.FillArray;

/*
Segregate even and odd nodes in a Link List
Easy Accuracy: 64.41% Submissions: 28267 Points: 2
Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the
modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.


Example 1:

Input:
N = 7
Link List:
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

Explanation: 8,2,4,6 are the even numbers,
so they appear first and 17,15,9 are odd
numbers that appear later.

Example 2:

Input:
N = 4
Link List:
1 -> 3 -> 5 -> 7

Output: 1 3 5 7

Explanation: There is no even number.
So no need for modification.

 */
public class OddEven {
    public static void main(String[] args) {
        Node l = divide(10, Node.create(FillArray.fill(10)));
        Node.print(l);
    }
    
    static Node divide(int n, Node head) {
        Node even = new Node(-1), odd = new Node(-1);
        Node e = even, o = odd;
        Node ptr = head;
        while (ptr != null) {
            if (ptr.data % 2 == 0) {
                even.next = ptr;
                even = even.next;
            }
            else {
                odd.next = ptr;
                odd = odd.next;
            }
            ptr = ptr.next;
        }
        odd.next = null;
        
        e = e.next;
        o = o.next;
        
        if (e != null) {
            even.next = o;
            head = e;
        }
        
        else {
            head = o;
        }
        
        return head;
    }
}

