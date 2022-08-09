package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;
// Program to print all the permutations of integer array.
public class Permutations {
    public static List<List<Integer>> result;
    
    public static void dfs(List<Integer> permutation, List<Integer> dt) {
        if (dt.size() == 0) {
            result.add(permutation);
            return;
        }
        for(Integer num:dt)
        {
            List<Integer> tempP = new ArrayList<>(permutation);
            List<Integer> tempDt = new ArrayList<>(dt);
            tempP.add(num);
            tempDt.remove(num);
            dfs(tempP,tempDt);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> dt = new ArrayList<>();
        for (int num : nums)
            dt.add(num);
        dfs(new ArrayList<>(), dt);
        return result;
    }
}
