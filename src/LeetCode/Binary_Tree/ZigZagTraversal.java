package LeetCode.Binary_Tree;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        boolean level = true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                if (level) {
                    list.add(curr.val);
                }

                else {
                    list.add(0, curr.val); // adding in reverse order
                }
                
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            level = !level;
            
            result.add(list);
        }
        
        return result;
    }
    
}
