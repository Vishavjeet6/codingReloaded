package coding.graph;

import java.util.*;

public class A12ReorderRoutes12 {



//    https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

    static class Solution {
        public int minReorder(int n, int[][] connections) {
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            Map<Integer, List<Integer>> actual = new HashMap<>();

            for(int[] connection : connections) {
                actual.computeIfAbsent(connection[0], x-> new ArrayList<>()).add(connection[1]);
                adjList.computeIfAbsent(connection[0], x-> new ArrayList<>()).add(connection[1]);
                adjList.computeIfAbsent(connection[1], x-> new ArrayList<>()).add(connection[0]);
            }

            int start=0;
            int ans=0;
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start]=true;
            while(!q.isEmpty()){
                int node = q.poll();

                for(int neigh : adjList.get(node)){
                    if(!visited[neigh]){
                        if(!actual.getOrDefault(neigh, new ArrayList<>()).contains(node)){
                            ans++;
                        }
                        visited[neigh] = true;
                        q.add(neigh);
                    }
                }
            }



            return ans;


        }
    }

    public static void main(String[] args) {

    }
}
