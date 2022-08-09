package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.*;

/*
Diagonal Traversal of Binary Tree
Difficulty Level : Medium
Last Updated : 21 Jan, 2022
Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree
belonging to the same line.

Input : Root of below tree
            8
        3         10
    1         6       14
           4    7   13
           
Output :
Diagonal Traversal of binary tree :
 8 10 14
 3 6 7 13
 1 4
Observation : root and root->right values will be prioritized over all root->left values.
 */
public class DiagonalTraversal {
    public static void main(String[] args) {
        int[] a = FillArray.fill(10);
        Node.printBinaryTree(Node.create(a));
        System.out.println(diagonalTraversal(Node.create(a)));
    }
    
    static ArrayList<Integer> diagonalTraversal(Node root) {
        
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        helper(root, 0, map);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            List<Integer> l = entry.getValue().stream().toList();
            ans.addAll(l);
        }
        return ans;
    }
    
    private static void helper(Node root, int i, TreeMap<Integer, Vector<Integer>> map) {
        if (root == null) return;
        
        Vector<Integer> v = map.get(i);
        
        if (v == null) {
            v = new Vector<>();
            v.add(root.data);
        }
        
        else {
            v.add(root.data);
        }
        
        map.put(i, v);
        
        helper(root.left, i + 1, map);
        helper(root.right, i, map);
    }
}
