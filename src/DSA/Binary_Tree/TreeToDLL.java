package DSA.Binary_Tree;

/*
Binary Tree to DLL
Hard Accuracy: 41.34% Submissions: 89086 Points: 8
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are
to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as
Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of
the DLL.

TreeToList

Example 1:

Input:
      1
    /  \
   3    2
Output:
3 1 2
2 1 3
Explanation: DLL would be 3<=>1<=>2
Example 2:

Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30
30 10 60 20 40
Explanation:  DLL would be
40<=>20<=>60<=>10<=>30.
 */
public class TreeToDLL {
    static Node prev = null, head;
    
    static Node bToDLL(Node root) {
        // Method 1
        // store inorder in a list and construct the DLL
        
        // Method 2
        // Morris Traversal
        Node dummy = new Node();
        Node head = dummy;
        
        while (root != null) {
            if (root.left != null) {
                Node prev = root.left;
                
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                }
                
            }
            
            else {
                root.left = dummy;
                dummy.right = root;
                dummy = root;
                root = root.right;
            }
        }
        head.right.left = null;
        return head.right;
    }
    
    // left === prev
    // right === next
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.right.left = new Node(36);
        root.left.left = new Node(25);
        root.left.right = new Node(30);

//        Node.inorder(root);
        Node.inorder(bToDLL(root));
    }

//    static Node bToDll(Node root) {
//        if (root == null) return root;
//
//        Node left = bToDll(root.left);
//
//        if (left == null && prev == null) {
//            head = root;
//        }
//        else {
//            prev.right = root;
//            root.left = prev;
//        }
//        prev = root;
//
//        bToDll(root.right);
//
//        return head;
//    }
//
    
}
