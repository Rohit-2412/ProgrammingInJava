package DSA.Linked_List;

import Utility.FillArray;

/*
Quick Sort on Linked List
Medium Accuracy: 65.03% Submissions: 11602 Points: 4
Sort the given Linked List using quicksort. which takes O(n^2) time in worst case and O(n Log n) in average and best
cases, otherwise you may get TLE.

Input:
In this problem, method takes 1 argument: address of the head of the linked list. The function should not read any
input from stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the
linked list.
There are multiple test cases. For each test case, this method will be called individually.

Output:
Set *headRef to head of resultant linked list.

User Task:
The task is to complete the function quickSort() which should set the *headRef to head of the resultant linked list.

Constraints:
1<=T<=100
1<=N<=200

Note: If you use "Test" or "Expected Output Button" use below example format

Example:
Input:
2
3
1 6 2
4
1 9 3 8

Output:
1 2 6
1 3 8 9

Explanation:
Testcase 1: After sorting the nodes, we have 1, 2 and 6.
Testcase 2: After sorting the nodes, we have 1, 3, 8 and 9.
 
 */
public class QuickSort {
    
    public static void main(String[] args) {
        int[] arr = FillArray.fill(6, 15);
        Node l = Node.create(arr);
        Node.print(quickSort(l));
    }
    
    static Node quickSort(Node head) {
        
        if (head == null || head.next == null) return head;
        
        Node tail = getTail(head);
        solve(head, tail);
        return head;
    }
    
    private static void solve(Node head, Node tail) {
        if (head == null || head.next == null || head == tail) {
            return;
        }
        
        Node pivot = partition(head, tail);
        solve(head, pivot);
        if (pivot != null && pivot == head) {
            solve(pivot.next, tail);
        }
        
        else if (pivot != null && pivot.next != null) {
            solve(pivot.next.next, tail);
        }
    }
    
    private static Node partition(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        
        Node curr = start;
        Node prev = start;
        int pivotData = end.data;
        
        // we're partitioning some part of LL
        // that's why we've used current != tail.next
        while (start != end) {
            if (start.data < pivotData) {
                prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        int temp = curr.data;
        curr.data = pivotData;
        end.data = temp;
        
        return prev;
    }
    
    private static Node getTail(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    
 /*
    
    public static Node quickSort(Node head) {
        if (head == null) return null;
        
        Node pivot = head;
        head = head.next;
        pivot.next = null;
        if (head == null) return pivot;
        
        Node small = new Node(-1);
        Node large = new Node(-1);
        Node s = small;
        Node l = large;
        Node p = pivot;
        
        while (head != null) {
            if (head.data < pivot.data) {
                s.next = head;
                s = s.next;
            }
            else if (head.data > pivot.data) {
                l.next = head;
                l = l.next;
            }
            else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        
        l.next = null;
        p.next = null;
        s.next = null;
        
        Node ss = quickSort(small.next);
        
        if (ss == null) {
            ss = pivot;
        }
        else {
            Node sss = ss;
            while (sss.next != null) sss = sss.next;
            sss.next = pivot;
        }
        
        p.next = quickSort(large.next);
        return ss;
        
    }
    
*/


/*
    public static Node quickSort(Node node) {
        //Your code here
        int n = 0;
        
        Node dummy1 = node;
        Node dummy2 = node;
        Node ans = node;
        while (dummy1 != null) {
            n++;
            dummy1 = dummy1.next;
        }
        
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = dummy2.data;
            dummy2 = dummy2.next;
        }
        
        Arrays.sort(a);
        int j = 0;
        while (ans != null) {
            ans.data = a[j];
            j++;
            ans = ans.next;
        }
        
        return node;
    }
    
*/
}
