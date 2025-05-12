package coding.graph;

import java.util.*;

public class A24CourseScheduleII24 {
//    https://leetcode.com/problems/course-schedule-ii/

    static class Solution {

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
            if(ans.size() != V) return new ArrayList<>();
            return ans;

        }


        public int[] findOrder(int V, int[][] edges) {
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int[] indegree = new int[V];
            for(int[] edge : edges){
                adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
                indegree[edge[0]]++;
            }
            ArrayList<Integer> ansList =  bfs(adjList, indegree, V);
            // System.out.println(ansList);
            int[] array = ansList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            return array;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        });
        System.out.println(Arrays.toString(result));
    }


    

}

