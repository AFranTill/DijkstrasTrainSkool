import java.util.*;

public class DijkstraAlgorithm {

    public static void dijkstra(int[][] graph, int start) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize all distances as infinite and visited as false
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        // Distance from start node to itself is 0
        distances[start] = 0;

        // Loop through all nodes
        for (int i = 0; i < numNodes - 1; i++) {
            // Select the node with the smallest tentative distance
            int minIndex = getMinIndex(distances, visited);
            visited[minIndex] = true;

            // Update the tentative distances of its neighbors
            for (int j = 0; j < numNodes; j++) {
                if (graph[minIndex][j] > 0 && !visited[j] && distances[minIndex] != Integer.MAX_VALUE
                        && distances[minIndex] + graph[minIndex][j] < distances[j]) {
                    distances[j] = distances[minIndex] + graph[minIndex][j];
                }
            }
        }

        // Print the shortest distances from start node to all other nodes
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println(i + ": " + distances[i]);
        }
    }

    private static int getMinIndex(int[] distances, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] <= minDist) {
                minDist = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        // Example graph
        int[][] graph = { { 0, 4, 0, 0, 0, 0 }, 
                          { 0, 0, 2, 0, 0, 0 },
                          { 3, 0, 0, 5, 0, 0 },
                          { 0, 0, 0, 0, 1, 0 },
                          { 0, 0, 0, 0, 0, 3 },
                          { 0, 0, 0, 1, 0, 0 } };

        dijkstra(graph, 0);
    }
}
