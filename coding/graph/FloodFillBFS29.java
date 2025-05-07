package coding.graph;

import java.util.*;

public class FloodFillBFS29 {

//    https://leetcode.com/problems/flood-fill/description/

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int M = image.length;
            int N = image[0].length;
            int startColor = image[sr][sc];
            // v.v.v.v.v.imp   avoid infinite loop
            if (startColor == color) return image;
            Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
            int[] dx = new int[] {-1, 0, 1, 0};
            int[] dy = new int[] {0, 1, 0, -1};
            q.add(new AbstractMap.SimpleEntry<>(sr, sc));
            while(!q.isEmpty()){
                Map.Entry<Integer, Integer> node = q.poll();
                int x = node.getKey();
                int y = node.getValue();
                image[x][y] = color;
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < M && newY >= 0 && newY < N &&
                            image[newX][newY] == startColor) {
                        q.add(new AbstractMap.SimpleEntry<>(newX, newY));
                    }
                }
            }
            return image;
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
        Solution solution = new Solution();
        int[][] result = solution.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}
