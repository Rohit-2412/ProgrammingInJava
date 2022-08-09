package DSA.Linked_List;

import Utility.FillArray;

public class SplitCircularLL {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(7, 20);
        Node l = Node.create(arr);
        Node.print(l);
    }
    
    static void splitList(circular_LinkedList list) {
        if (list.head.next == list.head) {
            list.head1 = list.head;
            list.head2 = null;
            return;
        }
        
        Node slow = list.head;
        Node fast = list.head;
        
        while (fast.next != list.head && fast.next.next != list.head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // storing the next node after half of ll in temp
        Node temp = slow.next;
        slow.next = list.head; // making 1st part circular
        
        // starting point of 2nd list
        list.head1 = list.head;
        list.head2 = temp;
        // making 2nd part circular
        while (temp.next != list.head)
            temp = temp.next;
        temp.next = list.head2;
    }
    
    static class circular_LinkedList {
        Node head, head1, head2;
        Node last = null;
    }
}
