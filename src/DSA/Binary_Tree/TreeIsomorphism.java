package DSA.Binary_Tree;

import Utility.FillArray;

/*
Check if Tree is Isomorphic
Easy Accuracy: 50.16% Submissions: 44232 Points: 2
Given two Binary Trees. Check whether they are Isomorphic or not.

Note:
Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and
right children of several nodes. Any number of nodes at any level can have their children swapped. Two empty trees
are isomorphic.
For example, the following two trees are isomorphic with the following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
ISomorphicTrees

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes

 */
public class TreeIsomorphism {
    public static void main(String[] args) {
        int[] arr1 = FillArray.fill(15, 2);
        int[] arr2 = FillArray.fill(15, 2);
        Node root1 = Node.create(arr1);
        Node root2 = Node.create(arr2);
        
        System.out.println(isIsomorphic(root1, root2));
    }
    
    static boolean isIsomorphic(Node root1, Node root2) {
        return check(root1, root2);
    }
    
    static boolean check(Node p1, Node p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        
        if (p1 == null || p2 == null) return false;
        
        if (p1.data != p2.data) return false;
        
        Node l1 = (p1.left != null) ? p1.left : null;
        Node l2 = (p2.left != null) ? p2.left : null;
        
        Node r1 = (p1.right != null) ? p1.right : null;
        Node r2 = (p2.right != null) ? p2.right : null;
        
        return check(l1, l2) && check(r1, r2) || check(l1, r2) && check(l2, r1);
    }
}
