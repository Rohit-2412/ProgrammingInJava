package DSA.Binary_Tree;

public class CheckBalanced {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isBalanced(Node.create(a)));
    }
    
    static Pair isBalancedFast(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        Pair left = isBalancedFast(root.left);
        Pair right = isBalancedFast(root.right);
        
        boolean diff = Math.abs(left.height - right.height) <= 1;
        Pair ans = new Pair();
        ans.balance = left.balance && right.balance && diff;
        ans.height = Math.max(left.height, right.height) + 1;
        return ans;
    }
    
    static boolean isBalanced(Node root) {
        /* Approach 1  */
        /* T.C = O(n^2) */
        
//        if (root == null) return true;
//
//        if (!isBalanced(root.left)) return false;
//
//        if (!isBalanced(root.right)) return false;
//
//        int lh = height(root.left);
//        int rh = height(root.right);
//
//        return Math.abs(lh - rh) <= 1;
    
        /* Approach 2 */
        /* T.C = O(n) */
        
        return isBalancedFast(root).balance;
    }
    
    static int height(Node node) {
        if (node == null) return 0;
        
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        
        return 1 + Math.max(lHeight, rHeight);
    }
    
    static class Pair {
        boolean balance;
        int height;
        
        public Pair() {
            this.balance = true;
            this.height = 0;
        }
        
        public Pair(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }
    
}
