package DSA.Binary_Tree;

import java.util.*;

public class TopView {
    
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        Node.printBinaryTree(Node.create(a));
        System.out.println(topView(Node.create(a)));
        System.out.println(topViewFast(Node.create(a)));
    }
    
    private static ArrayList<Integer> topViewFast(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        TreeMap<Integer, Integer> topNode = new TreeMap<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
                Pair temp = q.poll();
                
                Node front = temp.node;
                int hd = temp.height;
                
                if (!topNode.containsKey(hd)) {
                    topNode.put(hd, front.data);
                }
                
                if (front.left != null) {
                    q.add(new Pair(front.left, hd - 1));
                }
                if (front.right != null) {
                    q.add(new Pair(front.right, hd + 1));
                }
            }
        
        for (Map.Entry<Integer, Integer> entry : topNode.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
    
    private static ArrayList<Integer> topView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Pair temp = null;
        Node node = null;
        
        while (!q.isEmpty()) {
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                temp = q.poll();
                node = temp.node;
                
                if (!map.containsKey(temp.height)) {
                    map.put(temp.height, node.data);
                }
                
                if (node.left != null) {
                    q.add(new Pair(node.left, temp.height - 1));
                }
                
                if (node.right != null) {
                    q.add(new Pair(node.right, temp.height + 1));
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
    
    static class Pair {
        Node node;
        int height;
        
        Pair() { }
        
        public Pair(Node node, int height) {
            this.node = node;
            this.height = height;
        }
    }
}
