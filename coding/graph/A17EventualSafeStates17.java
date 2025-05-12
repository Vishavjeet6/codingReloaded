package coding.graph;

import java.util.*;

public class A17EventualSafeStates17 {

//    https://www.geeksforgeeks.org/problems/eventual-safe-states/1


    static class Solution {

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

            // Your code here
            boolean[] visitedNodes = new boolean[V];
            boolean[] currentPath = new boolean[V];
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i<V; i++){
                if(!visitedNodes[i]){
                    dfs(adj, visitedNodes, currentPath, i);
                }
            }
            for(int i=0; i<V; i++){
                if(!currentPath[i]){
                    ans.add(i);
                }
            }
            return ans;
        }

        public boolean dfs(List<List<Integer>> adj, boolean[] visitedNodes, boolean[] currentPath, int node){
            visitedNodes[node] = true;
            currentPath[node] = true;
            for(int neigh : adj.get(node)){
                if(!visitedNodes[neigh]){
                    if(dfs(adj, visitedNodes, currentPath, neigh)) return true;
                }else{
                    if(currentPath[neigh]){
                        return true;
                    }
                }
            }
            currentPath[node] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int V = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int E = 7;
        int[][] edgeList = new int[][]{
                {0, 1}, {0, 2}, {1, 2}, {1, 3}, {3, 0}, {4, 5}, {2, 5}
        };
        for(int i=0; i<E; i++){
            int u = edgeList[i][0];
            int v = edgeList[i][1];
            adj.get(u).add(v);
        }
        System.out.println(obj.eventualSafeNodes(7, adj));

    }
}
