package coding.graph;

import java.util.ArrayList;
import java.util.List;

public class A14CycleDetectionInUndirectedGraphUsingDFS14 {
//    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

    static class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {

            // Code here
            int vertices = adj.size();
            boolean[] visited = new boolean[vertices];
            for(int i=0; i<vertices; i++) {
                if(!visited[i]){
                    if(dfs(adj, visited,-1, i)) return true;
                }
            }
            return false;
        }

        public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent, int node) {
            visited[node] = true;
            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    if(dfs(adj, visited, node, neigh)){
//                        found cycle in subsequent calls
                        return true;
                    }
                }else if(visited[neigh] && neigh != parent){
//                    found cycle
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(0, 2, 4)),
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(2, 4)),
                new ArrayList<>(List.of(1, 3))
        ));
        System.out.println(obj.isCycle(adj));
    }
}
