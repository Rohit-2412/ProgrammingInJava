package DSA.Linked_List;

import Utility.FillArray;

public class DNFSortLL {
    public static void main(String[] args) {
        Node.print(segregate(Node.create(FillArray.fill(10, 3))));
    }
    
    static Node segregate(Node head) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        
        Node dummyNode = head;
        
        
        while (dummyNode != null) {
            if (dummyNode.data == 0) {
                zeroes++;
            }
            else if (dummyNode.data == 1) {
                ones++;
            }
            else {
                twos++;
            }
            
            dummyNode = dummyNode.next;
        }
        
        dummyNode = head;
        
        while (dummyNode != null) {
            if (zeroes != 0) {
                dummyNode.data = 0;
                zeroes--;
            }
            else if (ones != 0) {
                dummyNode.data = 1;
                ones--;
            }
            else {
                dummyNode.data = 2;
                twos--;
            }
            
            dummyNode = dummyNode.next;
        }
        
        return head;
    }
}
