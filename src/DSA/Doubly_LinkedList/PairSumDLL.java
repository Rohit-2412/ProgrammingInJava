package DSA.Doubly_LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumDLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node l = Node.create(arr);
        Node.print(l);
        List<List<Integer>> ans = pairSum(l, 12);
        for (List<Integer> x : ans) {
            System.out.println(x);
        }
    }
    
    public static List<List<Integer>> pairSum(Node head, int sum) {
        Node left = head, right = head;
        List<List<Integer>> list = new ArrayList<>();
        int i = 0, j = 0;
        while (right.next != null) {
            right = right.next;
            j++;
        }
        
        while (left != right && right != null) {
            int tempSum = left.data + right.data;
            if (tempSum == sum) {
                list.add(Arrays.asList(i++, j--));
                left = left.next;
                right = right.prev;
            }
            else if (tempSum > sum) {
                right = right.prev;
                j--;
            }
            else {
                left = left.next;
                i++;
            }
        }
        return list;
    }
}
