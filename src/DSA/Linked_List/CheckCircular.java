package DSA.Linked_List;

import Utility.FillArray;

public class CheckCircular {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(7, 15);
        Node l = Node.create(arr);
        l.next.next.next.next.next = l;
        System.out.println(isCircular(l));
    }
    
    public static boolean isCircular(Node head) {
//        method 1

//        Node slow = head;
//        Node fast = head;
//        
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) return true;
//        }
//        return false;

//         method 2
        
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp == head || temp.next == head) break;
        }
        return temp.next != null;
    }
}
