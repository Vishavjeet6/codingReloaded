package coding.graph;

import java.util.*;

public class TopologicalSortUsingBFS22 {
//    https://www.geeksforgeeks.org/problems/topological-sort/1

    static class Solution {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int[] indegree = new int[V];
            for(int[] edge : edges){
                adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
                indegree[edge[1]]++;
            }

            return bfs(adjList, indegree, V);
        }

        public ArrayList<Integer> bfs(Map<Integer, List<Integer>> adjList, int[] indegree, int V){
            ArrayList<Integer> ans = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<V;i ++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int node = q.poll();
                ans.add(node);
                for(int neigh : adjList.getOrDefault(node, new ArrayList<>())){
                    indegree[neigh]--;
                    if(indegree[neigh] == 0){
                        q.add(neigh);
                    }
                }

            }
            return ans;
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
