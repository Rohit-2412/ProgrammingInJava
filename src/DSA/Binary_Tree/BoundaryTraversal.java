package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.ArrayList;

import static java.lang.System.out;

/*
Boundary Traversal of binary tree
Medium Accuracy: 26.78% Submissions: 100k+ Points: 4
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when
 you always travel preferring the left subtree over the right subtree.
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the
 leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the
 root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

Example 1:

Input:
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
      / \
     8   9
   
Output: 1 2 4 8 9 6 7 3
*/
public class BoundaryTraversal {
    
    public static void main(String[] args) {
        int[] a = FillArray.fill(11);
        Node.printBinaryTree(Node.create(a));
        Node x = Node.create(a);
        out.println(boundary(x));
    }
    
    static ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.data);
        if (root.left != null) {
            left(root.left, result);
        }
        if (root.left != null || root.right != null) {
            bottom(root, result);
        }
        if (root.right != null) {
            right(root.right, result);
        }
        return result;
    }
    
    private static void left(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            return;
        }
        result.add(root.data);
        if (root.left != null) {
            left(root.left, result);
        }
        else {
            left(root.right, result);
        }
    }
    
    private static void right(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.right != null) {
            right(root.right, result);
        }
        else {
            right(root.left, result);
        }
        result.add(root.data);
    }
    
    private static void bottom(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        
        bottom(root.left, result);
        
        if (root.left == null && root.right == null) {
            result.add(root.data);
        }
        bottom(root.right, result);
    }
}
