package LeetCode.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null) return result;
        findPaths(root, targetSum, new ArrayList<Integer>());
        return result;
    }
    
    private void findPaths(TreeNode root, int targetSum, ArrayList<Integer> current) {
        if (root == null) return;
        
        current.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(current);
            return;
        }
        
        findPaths(root.left, targetSum - root.val, new ArrayList<>(current));
        findPaths(root.right, targetSum - root.val, new ArrayList<>(current));
    }
    
}
