package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any
// order.
public class Permutations2 {
    // approach 1 :
    // using set
//    public static Set<List<Integer>> result;
//
//    public static void dfs(List<Integer> permutation, List<Integer> dt) {
//        if (dt.size() == 0) {
//            result.add(permutation);
//            return;
//        }
//        for(Integer num:dt)
//        {
//            List<Integer> tempP = new ArrayList<>(permutation);
//            List<Integer> tempDt = new ArrayList<>(dt);
//            tempP.add(num);
//            tempDt.remove(num);
//            dfs(tempP,tempDt);
//        }
//    }
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        result = new HashSet<>();
//        List<Integer> dt = new ArrayList<>();
//        for (int num : nums)
//            dt.add(num);
//        dfs(new ArrayList<>(), dt);
//        return new LinkedList<>(result);
//    }
    
    //    approach 2
    public static List<List<Integer>> result;
    
    public static void dfs(List<Integer> permutation, Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            result.add(permutation);
            return;
        }
        for (Integer num : map.keySet()) {
            List<Integer> tempP = new ArrayList<>(permutation);
            Map<Integer, Integer> tempMap = new HashMap<>(map);
            tempP.add(num);
            tempMap.put(num, map.get(num) - 1);
            if (tempMap.get(num) == 0) {
                tempMap.remove(num);
            }
            dfs(tempP, tempMap);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        dfs(new ArrayList<>(), map);
        return result;
    }
}
