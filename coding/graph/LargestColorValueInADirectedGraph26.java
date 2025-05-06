package coding.graph;

import java.util.*;

public class LargestColorValueInADirectedGraph26 {

//    https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
    static class Solution {
        public int bfs(Map<Integer, List<Integer>> adjList, int[] indegree, int V, String colors){
            Queue<Integer> q = new LinkedList<>();
            int[][] colorMatrix = new int[V][26];
            int ans=0;
            for(int i=0; i<V;i ++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }

            // for loop
            int processed=0;


            while(!q.isEmpty()){
                int node = q.poll();
                processed++;
                colorMatrix[node][colors.charAt(node) - 'a']++;

                // ans yhi update krlo
                ans = Math.max(ans, colorMatrix[node][colors.charAt(node) - 'a']);

                for(int neigh : adjList.getOrDefault(node, new ArrayList<>())){
                    indegree[neigh]--;
                    if(indegree[neigh] == 0){
                        q.add(neigh);
                    }

                    // passing colors to the neigh
                    for(int j=0; j<26; j++){
                        colorMatrix[neigh][j] = Math.max(colorMatrix[neigh][j], colorMatrix[node][j]);
                    }
                }

            }
            return processed==V?ans:-1;
        }


        public int largestPathValue(String colors, int[][] edges) {
            // code here
            int V = colors.length();
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int[] indegree = new int[V];
            for(int[] edge : edges){
                adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
                indegree[edge[1]]++;
            }
            return bfs(adjList, indegree,  V, colors);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.largestPathValue("abaca", new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {3, 4}
        });
        System.out.println(result);
    }
}

