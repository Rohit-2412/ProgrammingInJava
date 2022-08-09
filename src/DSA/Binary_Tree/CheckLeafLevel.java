package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.HashSet;
import java.util.Set;

/*
Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input:
            1
          /   \
         2     3

Output: 1

Explanation:
Leaves 2 and 3 are at same level.
 */
public class CheckLeafLevel {
    
    
    public static void main(String[] args) {
        Node root = Node.create(FillArray.fill(127));
//        Node.printBinaryTree(root);
        System.out.println(check(root));
    }
    
    static Set<Integer> set;
    static boolean check(Node root) {
        set = new HashSet<>();
        level(root, 0);
        return set.size() == 1;
    }
    
    static void level(Node root, int lvl) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            set.add(lvl);
        }
        
        level(root.left, lvl + 1);
        level(root.right, lvl + 1);
    }
    
}
