package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.ArrayList;
import java.util.Stack;

public class ZigzagTraversal {
    public static void main(String[] args) {
        
        int[] a = FillArray.fill(25);
        Node.printBinaryTree(Node.create(a));
        System.out.println(zigZagTraversal(Node.create(a)));
    }
    
    static ArrayList<Integer> zigZagTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean lToR = true;
        currLevel.add(root);
        
        while (!currLevel.isEmpty()) {
            Node temp = currLevel.peek();
            currLevel.pop();
            
            if (temp != null) {
                ans.add(temp.data);
                
                if (lToR) {
                    if (temp.left != null) {
                        nextLevel.push(temp.left);
                    }
                    
                    if (temp.right != null) {
                        nextLevel.push(temp.right);
                    }
                }
                else {
                    if (temp.right != null) {
                        nextLevel.push(temp.right);
                    }
                    
                    if (temp.left != null) {
                        nextLevel.push(temp.left);
                    }
                    
                }
            }
            
            if (currLevel.isEmpty()) {
                lToR = !lToR;
                
                Stack<Node> x = currLevel;
                currLevel = nextLevel;
                nextLevel = x;
            }
        }
        
        return ans;
    }
}
