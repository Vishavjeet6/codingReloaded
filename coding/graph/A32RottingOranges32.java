package coding.graph;

import java.util.*;

public class A32RottingOranges32 {
//    https://leetcode.com/problems/rotting-oranges/description/


    static class Solution {
        public int orangesRotting(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            int minutes = 0;
            int fresh = 0;

            Queue<int[]> q = new LinkedList<>();

            int[] dx = new int[] {0, 1, 0, -1};
            int[] dy = new int[] {1, 0, -1, 0};

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(grid[i][j] == 2){
                        q.add(new int[]{i, j});
                    }else if(grid[i][j] == 1){
                        fresh++;
                    }
                }
            }
            while(!q.isEmpty() && fresh>0){
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    int[] curr = q.poll();
                    int x = curr[0], y = curr[1];
                    for(int i=0; i<4; i++){
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        if(newX >=0 && newX<M && newY>=0 && newY<N && grid[newX][newY]==1){
                            grid[newX][newY] = 2;
                            fresh--;
                            q.add(new int[]{newX, newY});
                        }
                    }
                }
                minutes++;
            }
            return fresh == 0 ? minutes : -1;
        }

        public static void main(String[] args) {
            int[][] grid = {
                    {2, 1, 1},
                    {1, 1, 0},
                    {0, 1, 1}
            };
            Solution solution = new Solution();
            int result = solution.orangesRotting(grid);
            System.out.println(result); // Output: 4
        }
    }
}




