package graphs.geeksforgeeks;

import graphs.Edge;
import graphs.Graph;
import graphs.GraphBuilder;

/**
 * Created by Sibendu Dey on 3/31/2017.
 */
public class DijkstraShortestPath {

    private static final int INF = 100000;

    public static void main(String argz[]) {
        Graph graph = GraphBuilder.createGraphWithWeight();
        performDijkstraShortestPath(graph);
    }

    private static void performDijkstraShortestPath(Graph graph) {
        boolean visited[] = new boolean[graph.getVertices()];
        int key[] = new int[graph.getVertices()];
        for (int i = 1; i < key.length; i++)
            key[i] = INF;

        for (int i = 0; i < graph.getVertices() - 1; i++) {
            int minVertex = fetchMin(visited, key);
            visited[minVertex] = true;
            for (Edge edge : graph.getEdgesListStreamed(minVertex)) {
                if (!visited[edge.getDest()] && (edge.getWeight() + key[minVertex]) < key[edge.getDest()]) {
                    key[edge.getDest()] = edge.getWeight() + key[minVertex];
                }
            }
        }

        printSolution(key);
    }

    private static void printSolution(int[] keys) {

        for (int i = 0; i < keys.length; i++)
            System.out.println("Vertex: " + i + " Key:" + keys[i]);
    }

    private static int fetchMin(boolean[] visited, int[] key) {
        int vertex = -1;
        int minimum = INF + 1;
        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && minimum > key[i]) {
                minimum = key[i];
                vertex = i;
            }
        }
        return vertex;
    }
}
