package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.Stack;

public class Postorder {
    
    public static void main(String[] args) {
        int[] a = FillArray.fill(16);
        Node b = Node.create(a);
        
        postorder(b);
        System.out.println();
        postorderIterative(b);
    }
    
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    static void postorderIterative(Node root) {
        if (root == null) {
            return;
        }
        
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        // create another stack to store postorder traversal
        Stack<Integer> integers = new Stack<>();
        
        // loop till stack is empty
        while (!stack.empty()) {
            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            integers.push(curr.data);
            
            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
            
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        
        // print postorder traversal
        while (!integers.empty()) {
            System.out.print(integers.pop() + " ");
        }
    }
}
