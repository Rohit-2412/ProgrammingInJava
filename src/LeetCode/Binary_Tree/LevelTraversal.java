package LeetCode.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    public static void main(String[] args) {
    
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // gives the first node
                TreeNode current = queue.remove();
                
                // adding the value to current Lvl list
                curr.add(current.val);
                
                // checking for left subtree
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(curr);
        }
        return result;
    }
}
