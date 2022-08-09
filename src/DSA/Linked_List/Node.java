package DSA.Linked_List;

import static java.lang.System.out;

public class Node {
    public Node next;
    public int data;
    
    Node(int key) {
        data = key;
        next = null;
    }
    
    Node() { }
    
    public static int length(Node ptr)
    {
        Node dummy = ptr;
        int len=0;
        while(dummy!=null)
        {
            len++;
            dummy=dummy.next;
        }
        return len;
    }
    
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        
        Node rest = reverse(head.next);
        
        head.next.next = head;
        
        head.next = null;
        
        return rest;
    }
    
    public static void print(Node head) {
        if(head==null) return;
        Node ptr = head;
        while (ptr != null) {
            out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        out.println("null");
    }
    
    private static Node insert(Node root, int val) {
        Node temp = new Node(val);
        Node ptr = new Node();
        ptr.next = null;
        
        if (root == null) {
            root = temp;
        }
        
        else {
            ptr = root;
            while (ptr.next != null) ptr = ptr.next;
            
            ptr.next = temp;
        }
        
        return root;
    }
    
    public static Node create(int[] arr) {
        Node root = null;
        
        for (int j : arr) {
            root = insert(root, j);
        }
        
        return root;
    }
}
