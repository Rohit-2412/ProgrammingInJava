package DSA.Binary_Search_Tree;

/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no subtree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2
Output: 2
Explanation: The following subtree is a
BST of size 2:
       2
    /    \
   N      8
 */
public class LargestBSTinBT {
    public static void main(String[] args) {
    
    }
    
    static int largestBst(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        int left = largestBst(root.left);
        int right = largestBst(root.right);
        
        if (isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return left + right + 1;
        }
        
        return Math.max(left, right);
    }
    
    private static boolean isBst(Node root, int minValue, int maxValue) {
        
        if (root == null) return true;
        
        if (root.data < minValue || root.data > maxValue) return false;
        
        boolean left = isBst(root.left, minValue, root.data);
        boolean right = isBst(root.right, root.data, maxValue);
        
        return left && right;
    }
}
