package DSA.Binary_Tree;

public class Mirror {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
//                   28, 29, 30, 31};
//        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Node b = new Node(5);
        b.left = new Node(3);
        b.right = new Node(6);
        b.left.left = new Node(2);
        b.left.right = new Node(4);
        Node.printBinaryTree(b);
        System.out.println();
        Node.printBinaryTree(mirror(b));
    }
    
    static Node mirror(Node node) {
        if (node == null) return null;
        
        Node copy = new Node(node.data);
        copy.left = mirror(node.right);
        copy.right = mirror(node.left);
        
        return copy;
    }
    
}
