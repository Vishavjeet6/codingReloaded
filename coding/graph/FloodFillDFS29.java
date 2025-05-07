package coding.graph;

import java.util.*;

public class FloodFillDFS29 {

    //    https://leetcode.com/problems/flood-fill/description/
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int M = image.length;
            int N = image[0].length;
            int startColor = image[sr][sc];
            // v.v.v.v.v.imp   avoid infinte loop
            if (startColor == color) return image;
            dfs(sr, sc, startColor, color, image, M, N);
            return image;
        }

        public void dfs(int i, int j, int startColor, int color, int[][] image, int M, int N){
            if(i<0 || j<0 || i>=M || j>= N || image[i][j] != startColor) return;
            image[i][j] = color;
            int[] dx = new int[] {-1, 0, 1, 0};
            int[] dy = new int[] {0, 1, 0, -1};
            for(int k=0; k<4; k++){
                int newX = i + dx[k];
                int newY = j + dy[k];
                dfs(newX, newY, startColor, color, image, M, N);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        FloodFillBFS29.Solution solution = new FloodFillBFS29.Solution();
        int[][] result = solution.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}
