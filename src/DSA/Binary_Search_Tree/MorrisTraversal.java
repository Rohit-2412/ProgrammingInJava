package DSA.Binary_Search_Tree;

public class MorrisTraversal {
    Node root;
    
    // Driver Code
    public static void main(String[] args) {
        Node tree;
        tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        
        traversal(tree);
    }
    
    /* Function to traverse a
    binary tree without recursion
    and without stack */
    static void traversal(Node root) {
        Node current, pre;
        
        if (root == null) {
            return;
        }
        
        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
				/* Find the inorder
					predecessor of current
				*/
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

				/* Make current as right
				child of its
				* inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

				/* Revert the changes made
				in the 'if' part
				to restore the original
				tree i.e., fix
				the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
            
        }
    }
}
