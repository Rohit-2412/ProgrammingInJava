package DSA.Linked_List;

import Utility.FillArray;

public class MiddleOfLL {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(855, 15);
        Node l = Node.create(arr);
        Node.print(l);
        System.out.println(middle(l).data);
    }
    
    public static Node middle(Node ptr) {
        Node slow = ptr;
        Node fast = ptr;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}
