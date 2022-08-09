package DSA.Binary_Search_Tree;

/*
Given a binary search tree, the task is to flatten it to a sorted list. Precisely, the value of each node must be
lesser than the values of all the nodes at its right, and its left node must be NULL after flattening. We must do it
in O(H) extra space where ‘H’ is the height of BST.
 */
public class FlattenBST {
    
    static Node prev;
    
    public static void main(String[] args) {
        Node root = Node.create(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Node.printBinaryTree(root);
        System.out.println();
        Node.inorder(flatten(root));
    }
    
    static Node flatten(Node root) {
        Node temp = new Node(-1);
        prev = temp;
        
        inorder(root);
        
        return temp.right;
    }
    
    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        prev.left = null;
        
        prev.right = root;
        
        prev = root;
        inorder(root.right);
    }
    
}
