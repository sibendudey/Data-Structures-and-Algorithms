package graphs.geeksforgeeks;

/**
 * Created by deysi on 3/28/2017.
 *
 * Why -> This algorithm find the shortest path between any pair of vertices if there is any possible path
 *
 * How -> The purpose of the algorithm is to go through all vertices ranging from 1 to V to find
 * if there is a shortest path exists from i to j going through K { 0 ,1 ,2, .... , K-1}
 *
 * Expected Time complexity -> O(n^3) where n = Number of vertices
 */

public class FloydWarshallAlgo {

    // Initially if there is no direct edge available, we assign an INF to graph[i][j]
    // indicating no direct edge is present from i to j
    private final static int INF = 99999;
    // Driver function
    public static void main(String args[])  {

        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        FloydWarshallAlgo algo = new FloydWarshallAlgo();
        algo.printShortestDistance( graph);
    }

    // Computes and prints the shortest distance between any pair of vertices
    private void printShortestDistance(int[][] graph) {

        int dist[][] = new int[graph.length][graph[0].length];
        for ( int i = 0 ; i < graph.length ; i++)
            for ( int j = 0 ; j < graph[0].length ; j++)
                dist[i][j] = graph[i][j];

        int V = graph.length;
        for ( int i = 0 ; i < V ; i++)
            for ( int j = 0 ; j < V ; j++)
                for ( int k = 0 ; k < V ; k++)  {
                    if ( k!=i && k!=j)  {
                        if ( dist[i][j] > dist[i][k] + dist[k][j])
                            dist[i][j] = dist[i][k] + dist[k][j];

                    }
                }
        printSolution(dist);
    }

    private void printSolution(int[][] dist) {

        for ( int i = 0 ; i < dist.length ; i++) {
            for (int j = 0; j < dist.length; j++)
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + " ");
            System.out.println();
        }
    }
}
