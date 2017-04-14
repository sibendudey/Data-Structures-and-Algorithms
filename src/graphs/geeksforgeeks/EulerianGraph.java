package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

/**
 * Created by Sibendu on 4/13/2017.
 *
 * Why -> To find whether the graph contains an eularian path or cycle or nothing.
 *
 * How -> Find whether the conditions for a graph to contain eularian path or cycle is satisfied or not?
 *
 * Time Complexity -> O(V+E) for DFS traversal with adjacency list.
 */
public class EulerianGraph {

    public static void main( String args[]) {
        Graph graph = GraphBuilder.createGraphWithAdjacencyList();
        printResult(graph);
    }

    private static void printResult(Graph graph) {
        
        if ( !isConnected(graph))    {
            System.out.println("Not an eulerian path or cycle");
        }

        int oddDegreeVertex = 0;

        for ( int i = 0 ; i < graph.getVertices() ; i++)    {
            if ( graph.getAdjList()[i] != null && graph.getAdjList()[i].size() % 2 != 0) {
                oddDegreeVertex++;
            }
        }

        if (oddDegreeVertex > 2)
            System.out.println("Not an eulerian path or cycle");

        switch ( oddDegreeVertex)   {
            case 0 : System.out.println("Graph is eulerian cycle");
            break;
            case 2: System.out.println("Graph is eularian path");
        }

    }

    private static boolean isConnected(Graph graph) {

        boolean visited[] = new boolean[graph.getVertices()];
        int v = 0;
        for ( ; v < graph.getVertices() ; v++)    {
            if ( graph.getAdjList()[v] != null && graph.getAdjList()[v].size() != 0)    {
                break;
            }
        }

        if ( v == graph.getVertices())
            return true;

        visited[v] = true;
        performDFS(graph , v , visited);

        for ( int i = 0 ; i < graph.getVertices() ; i++)    {
            if ( !visited[i] && graph.getAdjList()[i] != null && graph.getAdjList()[i].size() != 0)
                return false;
        }

        return true;
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
