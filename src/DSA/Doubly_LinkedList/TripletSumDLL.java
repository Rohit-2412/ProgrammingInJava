package DSA.Doubly_LinkedList;

public class TripletSumDLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9};
        Node l = Node.create(arr);
        System.out.println(tripletSum(l, 15));
    }
    
    public static int tripletSum(Node head, int sum) {
        Node current, first, last = head;
        int count = 0;
        while (last.next != null) {
            last = last.next;
        }
        for (current = head; current != null; current = current.next) {
            first = current.next;
            count += pairSum(first, last, sum - current.data);
        }
        return count;
    }
    
    public static int pairSum(Node head, Node tail, int sum) {
        Node left = head, right = tail;
        int count = 0;
        
        while (left != right && right != null && left != null && right.next != left) {
            int tempSum = left.data + right.data;
            if (tempSum == sum) {
                count++;
                left = left.next;
                right = right.prev;
            }
            else if (tempSum > sum) {
                right = right.prev;
            }
            else {
                left = left.next;
            }
        }
        return count;
    }
    
}
