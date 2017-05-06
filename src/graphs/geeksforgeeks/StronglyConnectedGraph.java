package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

/**
 * Created by Sibendu Dey on 4/13/2017.
 *
 * Why -> To find whether the graph is strongly connected or not. If an arbitrary vertex can reach other vertexes and
 *        vice-versa , if other vertexes can reach the vertex, then the Graph is strongly connected.
 *
 *  How -> 1. Perform a DFS traversal starting from any arbitrary vertex. Find whether it visits all the vertices.
 *            If not , return false :(
 *         2. Perform a DFS traversal starting from same vertex as step 1 but DFS should be peformed with
 *            transposed graph.Find whether it visits all the vertices, if not return false :(
 *         3. Return true, graph is strongly connected :)
 *
 *  Time complexity : Space - O(V)
 *                    Time - O( E + V ) same as DFS traversal if adjacency list is used
 *
 *
 */
public class StronglyConnectedGraph {

    public static void main( String args[]) {
        Graph graph = GraphBuilder.createGraphWithAdjacencyList();
        System.out.print(isStronglyConnectedGraph(graph));
    }

    private static boolean isStronglyConnectedGraph(Graph graph) {

        boolean[] visited = new boolean[graph.getVertices()];
        visited[0] = true;
        performDFS(graph , 0 , visited);

        for ( int i = 0 ; i < visited.length ; i++)
            if ( !visited[i])
                return false;

        for ( int i = 0 ; i < visited.length ; i++)
            visited[i] = false;

        Graph reversedGraph = reverseGraph(graph);

        visited[0] = true;
        performDFS(reversedGraph , 0 , visited);


        for ( int i = 0 ; i < visited.length ; i++)
            if ( !visited[i])
                return false;

        return true;
    }

    private static Graph reverseGraph(Graph graph) {

        Graph reversedGraph = new Graph(graph.getVertices(), graph.getEdges());
        for ( int currVertex = 0 ; currVertex < graph.getVertices() ; currVertex++)  {
            if ( graph.getAdjList()[currVertex] != null) {
                for (int adjacentVertex : graph.getAdjList()[currVertex]) {
                    reversedGraph.addEdge(adjacentVertex, currVertex);
                }
            }
        }
        return reversedGraph;
    }

    private static void performDFS(Graph graph, int currVertex, boolean[] visited) {

      if ( graph.getAdjList()[currVertex] != null)  {
          for ( int adjacentVertex : graph.getAdjList()[currVertex])    {
              if ( !visited[adjacentVertex]) {
                  visited[adjacentVertex] = true;
                  performDFS(graph, adjacentVertex , visited);
              }
          }
      }

    }
}
