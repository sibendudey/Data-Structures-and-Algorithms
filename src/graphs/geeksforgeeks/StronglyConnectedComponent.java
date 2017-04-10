package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

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
 */
public class StronglyConnectedComponent {

    public static void main( String args[]) {
        Graph graph = GraphBuilder.createGraphWithAdjacencyList();
    }
}
