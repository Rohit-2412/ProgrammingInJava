package LeetCode.Binary_Tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST {
    
    public static Set<Integer> s = new HashSet<>();
    
    public static void main(String[] args) {}
    
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (s.contains(k - root.val)) {
            return true;
        }
        s.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
