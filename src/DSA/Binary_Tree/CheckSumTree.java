package DSA.Binary_Tree;

public class CheckSumTree {
    
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        
        System.out.println(isSumTree(root));
    }
    
    static boolean isSumTree(Node root) {
        return isSumTreeFast(root).ans;
    }
    
    static Pair isSumTreeFast(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        
        if (root.left == null && root.right == null) {
            return new Pair(true, root.data);
        }
        
        Pair left = isSumTreeFast(root.left);
        Pair right = isSumTreeFast(root.right);
        
        boolean condition = root.data == left.sum + right.sum;
        boolean leftAns = left.ans;
        boolean rightAns = right.ans;
        
        Pair result = new Pair();
        if (leftAns && rightAns && condition) {
            result.ans = true;
            result.sum = 2 * root.data;
        }
        
        else {
            result.ans = false;
        }
        
        return result;
    }
    
    static class Pair {
        boolean ans;
        int sum;
        
        public Pair() {
            this.ans = true;
            this.sum = 0;
        }
        
        public Pair(boolean ans, int sum) {
            this.ans = ans;
            this.sum = sum;
        }
    }
    
}
