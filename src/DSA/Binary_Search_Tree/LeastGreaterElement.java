package DSA.Binary_Search_Tree;

import Utility.FillArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LeastGreaterElement {
    
    public static void main(String[] args) {
        int[] arr = FillArray.fill(15, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(replaceGreaterElement(arr)));
    }
    
    private static int[] replaceGreaterElement(int[] arr) {
        ArrayList<int[]> temp = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            temp.add(new int[] {arr[i], i});
        }
        int n = arr.length;
        // sorting the temp list
        temp.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        // now indexes vector will store the next greater
        // index for each temp[i].second index
        int[] indexes = nextGreaterIndexes(temp);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (indexes[temp.get(i)[1]] != -1) {
                res[temp.get(i)[1]]
                        = arr[indexes[temp.get(i)[1]]];
            }
        }
        return res;
    }
    
    private static int[] nextGreaterIndexes(ArrayList<int[]> temp) {
        
        int n = temp.size();
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int[] ints : temp) {
            if (stack.empty() || ints[1] < stack.peek()) {
                stack.push(ints[1]);
            }
            else {
                while (!stack.isEmpty() && ints[1] > stack.peek()) {
                    res[stack.peek()] = ints[1];
                    stack.pop();
                }
                stack.push(ints[1]);
            }
        }
        return res;
    }
}
