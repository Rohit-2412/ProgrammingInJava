package LeetCode.Binary_Tree;

public class TreeFromInorderPreorder {
    public int[] pre;
    public int[] in;
    public int idx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int s = 0, e = inorder.length - 1;
        pre = preorder;
        in = inorder;
        TreeNode result = helper(s, e);
        return result;
    }
    
    private TreeNode helper(int s, int e) {
        if (s > e) return null;
        
        int curr = pre[idx];
        idx++;
        
        TreeNode node = new TreeNode(curr);
        int pos = search(s, e, curr);
        node.left = helper(s, pos - 1);
        node.right = helper(pos + 1, e);
        return node;
    }
    
    private int search(int s, int e, int curr) {
        for (int i = s; i <= e; i++)
            if (in[i] == curr) return i;
        return 0;
    }
}
