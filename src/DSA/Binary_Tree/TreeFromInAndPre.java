package DSA.Binary_Tree;

public class TreeFromInAndPre {
    public int[] pre;
    public int[] in;
    public int idx = 0;
    
    public Node buildTree(int[] inorder, int[] preorder, int n) {
        int s = 0, e = n - 1;
        pre = preorder;
        in = inorder;
        return helper(s, e);
    }
    
    private Node helper(int s, int e) {
        if (s > e) return null;
        
        int curr = pre[idx];
        idx++;
        
        Node node = new Node(curr);
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
