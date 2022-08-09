package LeetCode.Binary_Tree;

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.right == null && root.left == null) {
            if (root.val == key) {
                return null;
            }
            else {
                return root;
            }
        }
        Pair s = new Pair(root, null);
        if (root.val == key) {
            TreeNode left = root.left;
            if (root.right != null) {
                TreeNode right = root.right;
                TreeNode ans = right;
                while (right.left != null) {
                    right = right.left;
                }
                right.left = left;
                return ans;
            }
            else {
                return root.left;
            }
        }
        DFS(s, key);
        return root;
    }
    
    public void DFS(Pair s, int key) {
        if (s.root == null) return;
        if (s.root.val == key) {
            TreeNode parent = s.parent;
            TreeNode left = s.root.left;
            TreeNode right = s.root.right;
            if (s.root.val < parent.val && left != null) {
                parent.left = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = right;
                return;
            }
            else if (s.root.val > parent.val && right != null) {
                parent.right = right;
                while (right.left != null) {
                    right = right.left;
                }
                right.left = left;
                return;
            }
            else if (s.root.val < parent.val && left == null) {
                parent.left = right;
            }
            else {
                parent.right = left;
            }
        }
        if (key < s.root.val) DFS(new Pair(s.root.left, s.root), key);
        if (key > s.root.val) DFS(new Pair(s.root.right, s.root), key);
    }
    
    class Pair {
        TreeNode root;
        TreeNode parent;
        
        Pair(TreeNode root, TreeNode parent) {
            
            this.root = root;
            this.parent = parent;
        }
    }
}
