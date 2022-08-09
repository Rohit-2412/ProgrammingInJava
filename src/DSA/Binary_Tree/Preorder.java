package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.Stack;

public class Preorder {
    public static void main(String[] args) {
        int[] a = FillArray.fill(16);
        Node b = Node.create(a);
        
        preorder(b);
        System.out.println();
        preorderIterative(b);
    }
    
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    static void preorderIterative(Node root) {
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        // loop till stack is empty
        while (!stack.empty()) {
            // pop a node from the stack and print it
            Node curr = stack.pop();
            
            System.out.print(curr.data + " ");
            
            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }
            
            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
            
            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }
}
