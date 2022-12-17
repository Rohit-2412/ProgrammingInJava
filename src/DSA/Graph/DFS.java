// 19-11-2022 23:02 November

package DSA.Graph;

import java.util.*;

public class DFS {
    static ArrayList<Integer> ans;
    
    public static void main(String[] args) {
        int u, v;
        
    }
    
    static ArrayList<Integer> bfs(int v, List<Pair> edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        makeAdjList(adjList, edges);
        
        for (int i = 0; i < v; i++) {
            if (!visited.get(i)) {
                bfsHelper(adjList, visited, ans, i);
            }
        }
        return null;
    }
    
    private static void bfsHelper(Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited,
            ArrayList<Integer> ans, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited.put(node, true);
        
        while (!q.isEmpty()) {
            int front = q.poll();
            
            ans.add(front);
            
            for(Integer i : adjList.get(front))
            {
                if(!visited.get(i)){
                    q.add(i);
                    visited.put(i,true);
                }
            }
        }
    }
    
    private static void makeAdjList(Map<Integer, List<Integer>> adjList, List<Pair> edges) {
        for (Pair edge : edges) {
            int u = edge.f;
            int v = edge.s;
            
            List<Integer> l1 = adjList.get(u);
            l1.add(v);
            
            adjList.put(u, l1);
            
            List<Integer> l2 = adjList.get(v);
            l2.add(u);
            adjList.put(v, l2);
        }
    }
    
    
    static class Pair {
        int f;
        int s;
        
        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}
