public class BellmanFord {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 5, 5, 0, 0},
                {0, 0, 0, -1, 0, 0},
                {0, -2, 0, 0, -1, 0},
                {0, 0, -2, 0, 1, 0},
                {0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0}
        };
        int[] distance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        for (int i = 0; i < graph.length - 1; i++) {
            for (int u = 0; u < graph.length; u++) {
                for (int v = 0; v < graph.length; v++) {
                    if (graph[u][v] != 0) {
                        if (distance[u] + graph[u][v] < distance[v]) {
                            distance[v] = distance[u] + graph[u][v];
                        }
                    }
                }
            }
        }
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0) {
                    if (distance[u] + graph[u][v] < distance[v]) {
                        System.out.println("Negative Cycle Detected");
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Distance of " + i + " from source: " + distance[i]);
        }

    }
}
