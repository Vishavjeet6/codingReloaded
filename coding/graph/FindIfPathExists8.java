package coding.graph;

import java.util.*;

public class FindIfPathExists8 {

//    https://leetcode.com/problems/find-if-path-exists-in-graph/description/

    static class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for(int[] edge : edges) {
                adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
                adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
            }

            return bfs(adjList, source, destination, n);

        }

        public boolean bfs(Map<Integer, List<Integer>> adjList, int source,
                           int destination, int n) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            visited[source]= true;
            while(!queue.isEmpty()){
                int node = queue.poll();
                if(node == destination) return true;
                for(int neigh : adjList.get(node)) {
                    if(!visited[neigh]) {
                        visited[neigh] = true;
                        queue.add(neigh);
                    }
                }
            }

            return false;
        }
    }

}
