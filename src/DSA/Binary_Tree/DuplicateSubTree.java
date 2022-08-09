package DSA.Binary_Tree;
/*
Check if a Binary Tree contains duplicate subtrees of size 2 or more
Difficulty Level : Hard
Last Updated : 28 Jun, 2021
Given a Binary Tree, check whether the Binary tree contains a duplicate sub-tree of size 2 or more.
Note : Two same leaf nodes are not considered as subtree size of a leaf node is one.

Input :  Binary Tree
               A
             /    \
           B        C
         /   \       \
        D     E       B
                     /  \
                    D    E
Output : Yes
Asked in : Google Interview
 */

import java.util.*;

public class DuplicateSubTree {
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node n = Node.create(a);
        System.out.println(dupSub(n));
    }
    
    static int dupSub(Node root) {
        HashSet<String> map = new HashSet<>();
        if (solve(root, map).equals("")) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    private static String solve(Node root, HashSet<String> map) {
        String s = "";
        
        if (root == null) return s + "#";
        
        String leftStr = solve(root.left, map);
        if (leftStr.equals(s)) {
            return s;
        }
        
        String rightStr = solve(root.right, map);
        if (rightStr.equals(s)) {
            return s;
        }
        
        s += root.data + leftStr + rightStr;
        
        if (s.length() > 3 && map.contains(s)) {
            return "";
        }
        
        map.add(s);
        return s;
    }
    
   int duplicateSub(Node root) {
        HashMap<Integer, ArrayList<A>> hm = new HashMap<>();
        ArrayList<A> ar = new ArrayList<A>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        A ob1 = new A();
        A ob = new A();
        while (q.size() > 0) {
            
            Node p = q.remove();
            if (hm.containsKey(p.data)) {
                
                ar = hm.get(p.data);
                for (int i = 0; i < ar.size(); i++) {
                    ob = ar.get(i);
                    int t = 0, t1 = 0;
                    if (p.left != null) {
                        if (p.left != null) {
                            if (ob.left == p.left.data) {
                                t = 1;
                            }
                        }
                        else if (ob.left == 0) t = 1;
                    }
                    
                    if (p.right != null) {
                        if (ob.right == p.right.data) t1 = 1;
                    }
                    
                    else if (ob.right == 0) {
                        t1 = 1;
                    }
                    
                    if (t == 1 && t1 == 1) return 1;
                    
                }
            }
            ob = new A();
            
            if (p.left != null) {
                q.add(p.left);
                ob.left = p.left.data;
            }
            if (p.right != null) {
                q.add(p.right);
                ob.right = p.right.data;
            }
            if (!hm.containsKey(p.data)) {
                ar = new ArrayList<>();
                ar.add(ob);
                hm.put(p.data, ar);
            }
            else {
                ar = hm.get(p.data);
                ar.add(ob);
                hm.put(p.data, ar);
            }
            
            
        }
        return 0;
    }
    
    static class A {
        int left;
        int right;
    }
    
}
