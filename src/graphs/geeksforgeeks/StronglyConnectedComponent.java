package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

import java.util.Stack;

/**
 * Created by Sibendu Dey on 4/10/2017.
 *
 * Why -> To find the strongly connected compoments of the Graph.
 *
 * How ->  1. Perform the DFS Traversal of the graph and store it in stack
 *         2. Find the transpose of the graph by reversing the edge directions.
 *         3. Perform the DFS again by pop the vertices out of stack and perform DFS using the popped vertex.
 *
 *  Explanation -> 1. To find the strongly connected components , we should traversal initially
 *                    from sink vertex and then moving to source vertices.
 *                 2. By performing a DFS traversal we get the sink vertices stored in the stack followed by source.
 *                    So when we perform a DFS traversal on the reversed graph using the popped out vertices from
 *                    stack , we have devised a method to find the SCC starting from sink vertices and then
 *                    moving to source vertices.
 *  Printed -> The number of strongly connected components.
 *
 *  Points to be noted -> A value of 1 for strongly connected component indicates it is a strongly connected graph.
 *
 */
public class StronglyConnectedComponent {

    public static void main( String args[]) {

        Graph graph = GraphBuilder.createGraphWithAdjacencyList();
        System.out.print("Number of Strongly Connected Components:"+ findStronglyConnectedComponents(graph));

    }

    private static int findStronglyConnectedComponents(Graph graph) {

        Stack<Integer> traversedVertices = performDFS( graph );

        if ( traversedVertices.size() != graph.getVertices())   {
            return 2;
        }

        Graph reversedGraph = reverseGraph(graph);
        return findStronglyConnectedComponentsUtil(reversedGraph , traversedVertices);

    }

    private static int findStronglyConnectedComponentsUtil(Graph graph, Stack<Integer> traversedVertices) {
        int stronglyConnectedComponents = 0;
        boolean[] visited = new boolean[graph.getVertices()];
        while ( traversedVertices.size() > 0)   {
            int currVertex = traversedVertices.pop();
            if ( !visited[currVertex])  {
                visited[currVertex] = true;
                performDFSUtil(graph, currVertex , null , visited);
                stronglyConnectedComponents++;
            }
        }
        return stronglyConnectedComponents;
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

    private static Stack<Integer> performDFS(Graph graph) {

        Stack<Integer> traversedVertices = new Stack<>();
        boolean visited[] = new boolean[graph.getVertices()];
        for ( int currVertex = 0 ; currVertex < graph.getVertices() ; currVertex++)
            if ( !visited[currVertex])   {
                visited[currVertex] = true;
                performDFSUtil( graph , currVertex , traversedVertices , visited);
                traversedVertices.push(currVertex);
            }

        return traversedVertices;
    }

    private static void performDFSUtil(Graph graph, int parentVertex, Stack<Integer> traversedVertices, boolean[] visited) {

        if (graph.getAdjList()[parentVertex] != null) {
            for (int adjacentVertex : graph.getAdjList()[parentVertex]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    performDFSUtil(graph, adjacentVertex, traversedVertices, visited);
                    if (traversedVertices != null)
                        traversedVertices.push(adjacentVertex);

                }
            }
        }
    }
}
