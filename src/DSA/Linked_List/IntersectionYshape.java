package DSA.Linked_List;

public class IntersectionYshape {
    public static void main(String[] args) {
        int[] a = {3, 6, 9, 15, 30};
        int[] b = {10, 15, 30};
        Node l1 = Node.create(a), l2 = Node.create(b);
        System.out.println(intersection(l1, l2));
    }
    
    public static int intersection(Node head1, Node head2) {
        while (head1 != null) {
            head1.data += 2001;
            head1 = head1.next;
        }
        
        while (head2 != null) {
            if (head2.data > 1000) {
                return head2.data - 1000;
            }
            head2 = head2.next;
        }
        return -1;
    }
}
