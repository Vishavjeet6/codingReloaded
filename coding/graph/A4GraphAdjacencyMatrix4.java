package coding.graph;

public class A4GraphAdjacencyMatrix4 {

    public static void main(String[] args) {
        int vertices = 5;
        int[][] edgeList = { {1, 2}, {2, 3}, {3, 4}, {4, 2}, {1, 3} };
//        1 indexed
        int[][] adjMatrix = new int[vertices][vertices];
//        undirected graph
        for (int[] edge : edgeList) {
            adjMatrix[edge[0]][edge[1]] = 1;
            adjMatrix[edge[1]][edge[0]] = 1;
        }

        printGraph(adjMatrix);
    }

    private static void printGraph(int[][] adjMatrix) {
        for (int i = 1; i < adjMatrix.length; i++) {
            System.out.print("Node : " + i + " Neighbours : ");
            for (int j = 1; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

}
