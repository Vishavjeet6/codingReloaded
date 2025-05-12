package coding.graph;

import java.util.LinkedList;
import java.util.Queue;

public class A10StepsByKnight10 {

    static class cell {
        int x;
        int y;
        int dis;

        public cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }


    static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        // Code here
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<cell> q = new LinkedList<>();

        q.add(new cell(KnightPos[0], KnightPos[1], 0));
        visited[KnightPos[0]][KnightPos[1]] = true;

        while(!q.isEmpty()) {
            cell node = q.poll();
            if(node.x == TargetPos[0] && node.y == TargetPos[1]) {
                return node.dis;
            }

            for(int i = 0; i < 8; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if(x >= 1 && x <= N && y >= 1 && y <= N && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new cell(x, y, node.dis + 1));
                }
            }


        }


        return 0;
    }


    public static void main(String[] args) {
        int N = 30;
        int[] knightPos = { 1, 1 };
        int[] targetPos = { 30, 30 };

        System.out.println(
                minStepToReachTarget(knightPos, targetPos, N));
    }
}
