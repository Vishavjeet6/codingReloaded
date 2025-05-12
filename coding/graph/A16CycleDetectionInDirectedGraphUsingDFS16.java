package coding.graph;


public class A16CycleDetectionInDirectedGraphUsingDFS16 {
//    https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

    static class Solution {
        public boolean isCyclic(int V, int[][] edges) {
            // code here
            int[][] adjMatrix = new int[V][V];
            for(int[] edge : edges){
                adjMatrix[edge[0]][edge[1]] = 1;
            }

            boolean[] currentPath = new boolean[V];
            boolean[] visited = new boolean[V];

            for(int i=0; i<V; i++){
                if(!visited[i]){
                    if(dfs(adjMatrix, visited, currentPath, i)) return true;
                }
            }
            return false;
        }

        public boolean dfs(int[][] adjMatrix, boolean[] visited, boolean[] currentPath, int node){
            visited[node] = true;
            currentPath[node] = true;
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[node][i] == 1){
                    int neigh = i;
                    if(!visited[neigh]){
                        if(dfs(adjMatrix, visited, currentPath, neigh)) return true;
                    }else{
                        if(currentPath[neigh]) return true;
                    }
                }
            }
            currentPath[node] = false;
            return false;
        }

    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isCyclic(4, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {3, 3}
        }));
    }


}
