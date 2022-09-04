package DSA.Binary_Search_Tree;

public class CountNodes {
    public static void main(String[] args) {
        Node root = Node.create(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
//        Node.printBinaryTree(root);
        System.out.println(countNode(root, 4, 8));
    }
    
    static int countNode(Node root, int low, int high) {
        if (root == null) return 0;
        
        if (root.data >= low && root.data <= high) {
            return 1 + countNode(root.left, low, high) + countNode(root.right, low, high);
        }
        
        else if (root.data > low) {
            return countNode(root.left, low, high);
        }
        else {
            return countNode(root.right, low, high);
        }
    }
}
