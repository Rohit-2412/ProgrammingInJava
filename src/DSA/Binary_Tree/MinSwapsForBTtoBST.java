package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*

https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/#:~:text=Given%20the
%20array%20representation%20of,it%20into%20Binary%20Search%20Tree.&text=Swap%201%3A%20Swap%20node%208,
node%209%20with%20node%2010.

Minimum swap required to convert binary tree to binary search tree
Difficulty Level : Hard
Last Updated : 28 Jan, 2022
Given the array representation of Complete Binary Tree i.e, if index i is the parent, index 2*i + 1 is the left child
 and index 2*i + 2 is the right child. The task is to find the minimum number of swap required to convert it into
 Binary Search Tree.

Examples:

Input : arr[] = { 5, 6, 7, 8, 9, 10, 11 }
Output : 3
Binary tree of the given array:
dig11

Swap 1: Swap node 8 with node 5.
Swap 2: Swap node 9 with node 10.
Swap 3: Swap node 10 with node 7.
dig21

So, minimum 3 swaps are required.


Input : arr[] = { 1, 2, 3 }
Output : 1
Binary tree of the given array:
dig3

After swapping node 1 with node 2.
dig41

So, only 1 swap required.
 */
public class MinSwapsForBTtoBST {
    static ArrayList<Integer> list;
    
    public static void main(String[] args) {
        int[] a = FillArray.fill(12);
        Node tree = Node.create(a);
        Node.printBinaryTree(tree);
        System.out.println("Swaps : " + swaps(tree));
    }
    
    static int swaps(Node root) {
        list = new ArrayList<>();
        inorder(root);
        return swapRequired(list.toArray(new Integer[0]));
    }
    
    static void inorder(Node root) {
        if (root == null) return;
        
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    
    public static int swapRequired(Integer[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], i);
        
        Arrays.sort(nums);
        
        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);
        
        // Initialize result
        int ans = 0;
        for (int i = 0; i < len; i++) {
            
            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }
            
            int j = i, cycle_size = 0;
            while (!visited[j]) {
                visited[j] = true;
                
                // move to next node
                j = map.get(nums[j]);
                cycle_size++;
            }
            
            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }
}
