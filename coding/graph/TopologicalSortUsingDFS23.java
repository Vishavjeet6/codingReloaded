package coding.graph;

import java.util.*;

public class TopologicalSortUsingDFS23 {
//    https://www.geeksforgeeks.org/problems/topological-sort/1
    static class Solution {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            Deque<Integer> deque = new ArrayDeque<>();
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for(int i=0; i<V; i++){
                adjList.put(i, new ArrayList<>());
            }
            for(int[] edge : edges){
                adjList.get(edge[0]).add(edge[1]);
            }
            boolean[] visited = new boolean[V];
            for(int i=0; i<V; i++){
                if(!visited[i]) {
                    dfs(i, adjList, visited, deque);
                }
            }
            // System.out.println(deque);
            return new ArrayList<>(deque);
        }

        public void dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, Deque<Integer> deque){
            visited[node] = true;
            for(int neigh : adjList.getOrDefault(node, new ArrayList<>())){
                if(!visited[neigh]){
                    dfs(neigh,adjList, visited, deque);
                }
            }
            deque.addFirst(node);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.topoSort(4, new int[][]{
                {3, 0}, {1, 0}, {2, 0}
        });
        System.out.println(result);
    }
}
