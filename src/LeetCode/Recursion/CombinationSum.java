package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
    
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public static void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(arr[idx]<=target) {
            temp.add(arr[idx]);
            // when we are including the current element in our answer
            findCombination(idx,arr,target-arr[idx],ans,temp);
            // removing the element which we added in above line
            temp.remove(temp.size()-1);
        }
        // if we are skipping the current element
        findCombination(idx+1,arr,target,ans,temp);
    }
}
