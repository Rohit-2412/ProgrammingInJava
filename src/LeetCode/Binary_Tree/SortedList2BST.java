package LeetCode.Binary_Tree;

import LeetCode.Linked_List.ListNode;

import java.util.ArrayList;

public class SortedList2BST {
    public static void main(String[] args) {
    
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }
        return makeBST(list, 0, list.size() - 1);
    }
    
    public TreeNode makeBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = makeBST(arr, start, mid - 1);
        root.right = makeBST(arr, mid + 1, end);
        return root;
    }
}
