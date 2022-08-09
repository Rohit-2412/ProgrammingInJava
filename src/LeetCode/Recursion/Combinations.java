package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(n, k, new ArrayList<>() );
        return result;
    }
    
    public void backtrack( int n, int k, List<Integer> current) {
        if (k==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(n==0)
            return;
        current.add(n);
        backtrack(n-1,k-1,current);
        current.remove(current.size()-1);
        backtrack(n-1,k,current);
    }
    
}
