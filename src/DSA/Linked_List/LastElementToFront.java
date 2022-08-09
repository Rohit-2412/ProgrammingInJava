package DSA.Linked_List;

public class LastElementToFront {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node list = Node.create(arr);
        Node.print(list);
        list = rearrange(list);
        Node.print(list);
        list = rearrange(list);
        Node.print(list);
        list = rearrange(list);
        Node.print(list);
        list = rearrange(list);
        Node.print(list);
    }
    
    public static Node rearrange(Node head) {
        if (head.next == null) {
            return head;
        }
        Node start, end, prev;
        
        start = head;
        end = head.next;
        prev = head;
        
        while (end.next != null) {
            end = end.next;
            prev = prev.next;
        }
        
        prev.next = null;
        end.next = start;
        return end;
    }
    
}
