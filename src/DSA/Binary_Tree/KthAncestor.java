package DSA.Binary_Tree;

/*
Kth ancestor of a node in binary tree | Set 2
Difficulty Level : Medium
Last Updated : 21 Mar, 2022
Given a binary tree in which nodes are numbered from 1 to n. Given a node and a positive integer K. We have to print
the Kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then print -1.
For example in the below given binary tree, the 2nd ancestor of 5 is 1. 3rd ancestor of node 5 will be -1.
 */
public class KthAncestor {
    
    static Node temp = null;
    static int k;
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Node root = Node.create(arr);
        Node.printBinaryTree(root);
        k = 3;
        kthAncestorDFS(root, 9);
    }
    
    // recursive function to calculate Kth ancestor
    static Node kthAncestorDFS(Node root, int node) {
        // Base case
        if (root == null) {
            return null;
        }
        
        if (root.data == node ||
                (temp = kthAncestorDFS(root.left, node)) != null ||
                (temp = kthAncestorDFS(root.right, node)) != null) {
            if (k > 0) {
                k--;
            }
            
            else if (k == 0) {
                // print the kth ancestor
                System.out.print("Kth ancestor is: " + root.data);
                
                // return null to stop further backtracking
                return null;
            }
            
            // return current node to previous call
            return root;
        }
        return null;
    }
}
