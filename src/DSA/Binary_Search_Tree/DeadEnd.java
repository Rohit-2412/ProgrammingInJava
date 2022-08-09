package DSA.Binary_Search_Tree;

/*
Check whether BST contains Dead End
Given a Binary search Tree that contains positive integer values greater than 0. The task is to complete the function
 isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means, we are not able
  to insert any element after that node.

Examples:

Input :
               8
             /   \
           5      9
         /  \
        2    7
       /
      1
      
Output : Yes
Explanation : Node "1" is the dead End because after that
              we can't insert any element.

Input :
              8
            /   \
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at
              node 9.
 */
public class DeadEnd {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(7);
        root.left.left = new Node(2);
        root.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(13);
        
        System.out.println(isDeadEnd(root));
    }
    
    static boolean isDeadEnd(Node root) {
        return solve(root, 1, Integer.MIN_VALUE);
    }
    
    private static boolean solve(Node root, int min, int max) {
        if (root == null) return false;
        System.out.println("root = " + root + ", min = " + min + ", max = " + max);
        if (min == max) return true;
        
        return solve(root.left, min, root.data - 1) || solve(root.right, root.data + 1, max);
    }
}
