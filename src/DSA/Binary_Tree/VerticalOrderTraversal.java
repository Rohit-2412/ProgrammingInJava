// 10-10-2022 12:25 October

package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        int[] arr = FillArray.fill(10, 50);
        Node root = Node.create(arr);
        Node.printBinaryTree(root);
        List<List<Integer>> ans = verticalOrder(root);
        
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
        
    }
    
    static <K, V> Pair make_pair(K first, V second) {
        Pair<K, V> ans = new Pair<>();
        ans.first = first;
        ans.second = second;
        return ans;
    }
    
    static void TreeTraversal(Node root, int level, int horizontalDist,
            TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        int value = root.data;
        
        if (map.get(horizontalDist) == null) {
            TreeMap<Integer, List<Integer>> h2 = new TreeMap<>();
            List<Integer> ts = new ArrayList<>();
            
            ts.add(value);
            h2.put(level, ts);
            map.put(horizontalDist, h2);
        }
        else {
            TreeMap<Integer, List<Integer>> h3 = map.get(horizontalDist);
            if (h3.get(horizontalDist) == null) {
                List<Integer> t = new ArrayList<>();
                t.add(value);
                h3.put(level, t);
            }
            else {
                List<Integer> t = h3.get(horizontalDist);
                t.add(value);
                h3.put(level, t);
            }
        }
        
        if (root.left != null) {
            TreeTraversal(root.left, level + 1, horizontalDist - 1, map);
        }
        if (root.right != null) {
            TreeTraversal(root.right, level + 1, horizontalDist + 1, map);
        }
    }
    
    static List<List<Integer>> verticalOrder(Node root) {
        
        // list of list to store answer
        List<List<Integer>> answer = new ArrayList<>();
        
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm = new TreeMap<>();
        TreeTraversal(root, 0, 0, hm);
        
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : hm.entrySet()) {
            TreeMap<Integer, List<Integer>> h1 = entry.getValue();
            List<Integer> list = new ArrayList<>();
            
            for (Map.Entry<Integer, List<Integer>> entry1 : h1.entrySet()) {
                List<Integer> subList = entry1.getValue();
                Collections.sort(subList);
                list.addAll(subList);
            }
            answer.add(list);
        }
        
        return answer;
    }
    
}

class Pair <K, V> {
    K first;
    V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public Pair() { }
}
