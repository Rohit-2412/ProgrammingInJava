package DSA.Binary_Tree;
// https://www.geeksforgeeks.org/check-given-graph-tree/#:~:text=Since%20the%20graph%20is%20undirected,graph%20is%20connected%2C%20otherwise%20not.
/*
Check if a given graph is tree or not
Difficulty Level : Medium
Last Updated : 24 Feb, 2022
Write a function that returns true if a given undirected graph is tree and false otherwise. For example, the
following graph is a tree.


cycleGraph

But the following graph is not a tree.


cycleGraph

An undirected graph is tree if it has the following properties.
1) There is no cycle.
2) The graph is connected.
For an undirected graph we can either use BFS or DFS to detect above two properties.
How to detect cycle in an undirected graph?
We can either use BFS or DFS. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already
visited and u is not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex,
we say that there is no cycle (See Detect cycle in an undirected graph for more details).
How to check for connectivity?
Since the graph is undirected, we can start BFS or DFS from any vertex and check if all vertices are reachable or not
. If all vertices are reachable, then graph is connected, otherwise not.
 


 */

import java.util.LinkedList;

public class IsTreeGraph {
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isTree()) {
            System.out.println("Graph is Tree");
        }
        else {
            System.out.println("Graph is not Tree");
        }
        
        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        
        if (g2.isTree()) {
            System.out.println("Graph is Tree");
        }
        else {
            System.out.println("Graph is not Tree");
        }
        
    }
    
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;
        
        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList<>();
        }
        
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
        
        boolean isCycle(int v, boolean[] visited, int parent) {
            visited[v] = true;
            Integer i;
    
            for (Integer integer : adj[v]) {
        
                i = integer;
        
                if (!visited[i]) {
                    if (isCycle(i, visited, v)) {
                        return true;
                    }
                }
        
                else if (i != parent) {
                    return true;
                }
            }
            return false;
        }
        
        boolean isTree() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                visited[i] = false;
            }
            
            if (isCycle(0, visited, -1)) {
                return false;
            }
            
            for (int u = 0; u < V; u++) {
                if (!visited[u]) return false;
            }
            
            return true;
        }
    }
}