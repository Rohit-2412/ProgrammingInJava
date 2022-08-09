package LeetCode.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public static void main(String[] args) {
    
    }
    
    // using iterative way
    
//        public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> values = new ArrayList<>();
//        if (root == null) {
//            return values;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop(); // this will store the root of Tree
//            values.add(0, curr.val);
//
//            // now we will check for left subtree and right subtree
//            // left subtree
//            if (curr.left != null) {
//                stack.push(curr.left);
//            }
//
//            // right subtree
//            if (curr.right != null) {
//                stack.push(curr.right);
//            }
//        }
//        return values;
//    }
    
    // inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(list, root);
        return list;
    }
    
    public void inorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
    
    // pre order
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorder(list, root);
        return list;
    }
    
    public void preorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
    
    // post order
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(list, root);
        return list;
    }
    
    public void postorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }
}
