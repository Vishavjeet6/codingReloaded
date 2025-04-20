package coding.graph;

public class LongestCycle19 {

//    https://leetcode.com/problems/longest-cycle-in-a-graph/description/

    static class Solution {

        int longestCycleLen = -1;
        public int longestCycle(int[] edges) {

            int V = edges.length;

            boolean[] visitedNodes = new boolean[V];
            int[] currentPathwithDepth = new int[V];

            for(int i=0; i<V; i++){
                if(!visitedNodes[i]){
                    dfs(edges, visitedNodes, currentPathwithDepth, i , 0);
                }
            }
            return longestCycleLen;
        }

        public void dfs(int[] adj, boolean[] visitedNodes, int[] currentPathwithDepth, int node, int cycleLength){
            cycleLength++;
            visitedNodes[node] = true;
            currentPathwithDepth[node] = cycleLength;
            int neigh = adj[node];
            if (neigh != -1) { // ✅ Safe check to avoid ArrayIndexOutOfBounds on -1 edges
                if(!visitedNodes[neigh]){
                    dfs(adj, visitedNodes, currentPathwithDepth, neigh, cycleLength);
                }else{
                    if(currentPathwithDepth[neigh] != 0){
                        int currCycleLength = currentPathwithDepth[node] - currentPathwithDepth[neigh] + 1;
                        longestCycleLen = Math.max(longestCycleLen, currCycleLength);
                    }
                }
            }
            currentPathwithDepth[node] = 0;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.longestCycle(new int[]{3, 3, 4, 2, 3}));
        Solution obj1 = new Solution();
        System.out.println(obj1.longestCycle(new int[]{2,-1,3,1}));

    }
}
