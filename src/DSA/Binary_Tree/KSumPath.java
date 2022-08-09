package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Print all target-sum paths in a binary tree
Difficulty Level : Hard
Last Updated : 29 Aug, 2021
A binary tree and a number target are given. Print every path in the tree with sum of the nodes in the path as target.
A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and
leaf node; and negative numbers can also be there in the tree.
Examples:


Input : target = 5
        Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5
        /   / \     \
       1   1   2     6
       
Output :
3 2
3 1 1
1 3 1
4 1
1 -1 4 1
-1 4 2
5
1 -1 5
 */
public class KSumPath {
    static List<Integer> path = new ArrayList<>();
    static int count = 0;
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 2, 4, 6, 9};
        Node tree = Node.create(arr);
        
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

//        printPath(root, 5);
        
        System.out.println();
        System.out.println();
        System.out.println(sumK(root, 5));
    }
    
    // for returning the number of combinations
    static int sumK(Node root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        finder(root, target, 0, map);
        return count;
    }
    
    private static void finder(Node root, int target, int currSum, Map<Integer, Integer> map) {
        if (root == null) return;
        
        currSum += root.data;
        
        if (map.containsKey(currSum - target)) {
            count += map.get(currSum - target);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        finder(root.left, target, currSum, map);
        finder(root.right, target, currSum, map);
        
        map.put(currSum, map.get(currSum) - 1);
    }
    
    // for printing path
    static void printPath(Node root, int sum) {
        printPathHelper(root, sum);
    }
    
    static void printPathHelper(Node root, int sum) {
        
        if (root == null) return;
        
        path.add(root.data);
        
        printPathHelper(root.left, sum);
        printPathHelper(root.right, sum);
        
        int f = 0;
        
        for (int i = path.size() - 1; i >= 0; i--) {
            f += path.get(i);
            
            if (f == sum) {
                count++;
                // print list from current index to end of the list
                for (int idx = i; idx < path.size(); idx++)
                    System.out.print(path.get(idx) + " ");
                System.out.println();
            }
        }
        
        path.remove(path.size() - 1);
    }
    
}
