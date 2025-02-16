package coding.graph;

import java.util.*;

public class BreadthFirstSearch6 {

    private static void bfs(Map<Integer, List<Integer>> adjList, int start, int vertices) {
        boolean[] visited = new boolean[vertices+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int x : adjList.get(node)){
                if(!visited[x]){
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] edgeList = {{0,1}, {1,4}, {1,2}, {2,3}};
        int vertices = 5;
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edgeList) {
//            if (!adjList.containsKey(edge[0])) {
//                adjList.put(edge[0], new ArrayList<>());
//            }
//            adjList.get(edge[0]).add(edge[1]);
//
//            if (!adjList.containsKey(edge[1])) {bfs
//                adjList.put(edge[1], new ArrayList<>());
//            }
//            adjList.get(edge[1]).add(edge[0]);
            adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);

        }

        int start = 0;
//        System.out.println(adjList);
        bfs(adjList, start, vertices);
    }
}
