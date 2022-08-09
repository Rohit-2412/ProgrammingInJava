package DSA.Binary_Tree;

import java.util.HashMap;
import java.util.Map;

/*
Maximum sum of nodes in Binary tree such that no two are adjacent
Difficulty Level : Hard
Last Updated : 16 May 2022
Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that the
sum of chosen nodes is maximum under a constraint that no two chosen nodes in the subset should be directly connected
 that is, if we have taken a node in our sum then we can’t take any of its children in consideration and vice versa.
 */
public class NonAdjacentNodesSum {
    static Map<Node, Integer> dp = new HashMap<>();
    
    public static void main(String[] args) {
        int[] arr = {1,
                     2, 3,
                     4, 5, 5, 4,
                     1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(getMaxSum(Node.create(arr)));
        System.out.println(maxSum(Node.create(arr)));
    }
    
    static int maxSum(Node root) {
        if (root == null) return 0;
        
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        
        int includedSum = root.data;
        
        if (root.left != null) {
            includedSum += maxSum(root.left.left) +
                    maxSum(root.left.right);
        }
        
        if (root.right != null) {
            includedSum += maxSum(root.right.left) +
                    maxSum(root.right.right);
        }
        
        int excludedSum = maxSum(root.left) + maxSum(root.right);
        
        dp.put(root, Math.max(includedSum, excludedSum));
        
        return Math.max(includedSum, excludedSum);
    }
    
    static int getMaxSum(Node root) {
        if (root == null) return 0;
        pair ans = helper(root);
        return Math.max(ans.first, ans.second);
    }
    
    private static pair helper(Node root) {
        if (root == null) return new pair(0, 0);
        
        pair l = helper(root.left);
        pair r = helper(root.right);
        
        pair temp = new pair();
        temp.first = l.second + r.second + root.data;
        temp.second = Math.max(l.first, l.second) +
                Math.max(r.first, r.second);
        
        return temp;
        
    }
    
    static class pair {
        int first;
        int second;
        
        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        public pair() {
            this.first = 0;
            this.second = 0;
        }
    }
}
