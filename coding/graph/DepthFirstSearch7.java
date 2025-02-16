package coding.graph;

import java.util.*;

public class DepthFirstSearch7 {

    public static void main(String[] args) {
        int[][] edgeList = {{0, 1}, {1, 4}, {1, 2}, {2, 3}};
        int vertices = 5;
        int start = 0;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edgeList) {
//            if (!adjList.containsKey(edge[0])) {
//                adjList.put(edge[0], new ArrayList<>());
//            }
//            adjList.get(edge[0]).add(edge[1]);
//
//            if (!adjList.containsKey(edge[1])) {
//                adjList.put(edge[1], new ArrayList<>());
//            }
//            adjList.get(edge[1]).add(edge[0]);
            adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        System.out.println("Stack DFS");
        dfs(adjList, start, vertices);
        boolean[] visited = new boolean[vertices + 1];
        System.out.println("Recursive DFS");
        dfsRecursive(adjList, start, vertices, visited);
    }

    private static void dfsRecursive(Map<Integer, List<Integer>> adjList, int start, int vertices, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : adjList.get(start)) {
            if (!visited[neighbor]) {
                dfsRecursive(adjList, neighbor, vertices, visited);
            }
        }

    }

    private static void dfs(Map<Integer, List<Integer>> adjList, int start, int vertices) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices + 1];
        stack.add(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}


