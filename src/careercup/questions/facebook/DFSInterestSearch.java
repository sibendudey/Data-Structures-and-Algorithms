package careercup.questions.facebook;

import graphs.Edge;
import graphs.Graph;
import graphs.GraphBuilder;

import java.util.Scanner;

/**
 * Created by Sibendu Dey on 5/12/2017.
 *
 * Why -> Careercup question -> https://www.careercup.com/question?id=5123528929050624
 *
 * How -> Perform DFS until the final vertex is reached. Use a stack to multiply the % values
 *          encountered to get the % of shares hold in that path.
 *
 * Time complexity ->
 *
 *
 */
public class DFSInterestSearch {

    public static void main(String args[])  {
        Graph graph = GraphBuilder.createGraphWithWeightAndAdjacencyList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source");
        int sourceVertex = sc.nextInt();
        System.out.println("Enter sink");
        int sinkVertex = sc.nextInt();
        performDFS( graph , sourceVertex , sinkVertex);

    }

    private static void performDFS(Graph graph, int sourceVertex, int sinkVertex) {

        float totalSum = 0;
        boolean visited[] = new boolean[graph.getVertices()];
        visited[sourceVertex] = true;
        for ( Edge edge: graph.getAdjListEdge()[sourceVertex])  {
            visited[edge.getDest()] = true;
            totalSum += performDFSUtil( graph , edge , sinkVertex  , visited);
            visited[edge.getDest()] = false;
        }

        System.out.print(totalSum);
    }

    private static float performDFSUtil(Graph graph, Edge edge, int sinkVertex, boolean[] visited) {

        if ( edge.getDest() == sinkVertex)   {
            return edge.getWeight();
        }

        if ( graph.getAdjListEdge()[edge.getDest()] == null)
            return 0;

        float totalShare = 0;

        for ( Edge nextEdge : graph.getAdjListEdge()[edge.getDest()])   {
            if ( !visited[nextEdge.getDest()])  {
                visited[nextEdge.getDest()] = true;
                totalShare += edge.getWeight() * performDFSUtil(graph , nextEdge, sinkVertex ,
                        visited);
                visited[nextEdge.getDest()] = false;

            }
        }
        return totalShare;
    }
}
