package coding.graph;

import java.util.*;

public class CycleDetectionInUndirectedGraphUsingBFS15 {
//    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
static class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {

        // Code here
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<vertices; i++) {
            if(!visited[i]){
                visited[i] = true;
                queue.add(i);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int neigh : adj.get(node)){
                        if(!visited[neigh]){
                            visited[neigh] = true;
                            parent[neigh] = node;
                            queue.add(neigh);
                        }else if(visited[neigh] && neigh != parent[node]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}

    public static void main(String[] args) {
        CycleDetectionInUndirectedGraphUsingDFS14.Solution obj = new CycleDetectionInUndirectedGraphUsingDFS14.Solution();
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
