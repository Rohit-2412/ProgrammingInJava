package DSA.Binary_Tree;

public class CheckSumTree {
    static boolean flag = true;
    
    static boolean isSumTree(Node root) {
        sumNode(root);
        return flag;
    }
    
    
    private static int sumNode(Node root) {
        if (!flag) return 0;
        
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) return root.data;
        
        int leftData = sumNode(root.left);
        int rightData = sumNode(root.right);
        
        if (root.data != (leftData + rightData)) {
            flag = false;
        }
        
        return root.data + leftData + rightData;
    }
    
}
