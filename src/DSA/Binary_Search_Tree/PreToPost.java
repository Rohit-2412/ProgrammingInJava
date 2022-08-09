package DSA.Binary_Search_Tree;

import java.util.Stack;

public class PreToPost {
    public static void main(String[] args) {
    
    }
    
    static Node postorder(int[] pre, int size) {
        Node root = new Node(pre[0]);
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        for (int i = 1; i < size; i++) {
            Node node = new Node(pre[i]);
            
            if (stack.peek().data < pre[i]) {
                while (!stack.isEmpty() && stack.peek().data < pre[i]) {
                    curr = stack.pop();
                }
                curr.right = node;
                curr = curr.right;
            }
            else {
                curr.left = node;
                curr = curr.left;
            }
            stack.add(node);
        }
        return root;
    }
}
