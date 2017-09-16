package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sibendu Dey on 3/24/2017.
 */


public class KruskalsAlgorithm {

    public static void main(String args[])  {


        Graph graph = GraphBuilder.createGraphWithWeight();


        // Sort the edges based on weight

        Collections.sort(graph.getEdgesList());

        // Perform the kruskal Algorithm

        List<Edge> minSpanningTreeEdges = executeKruskalAlgorithm(graph);
        minSpanningTreeEdges.forEach((edge) -> {System.out.println("Source:" + edge.getSrc() + " Destination:" + edge.getDest());} );

    }

    private static List<Edge> executeKruskalAlgorithm(Graph graph) {

        List<Edge> minSpanningTreeEdges = new ArrayList<>();
        int parent[] = new int[graph.getVertices()];

        for ( int i = 0 ; i < parent.length ; i++)
            parent[i] = -1;

        for ( int i = 0 ; i < graph.getEdgesList().size() && minSpanningTreeEdges.size() != graph.getVertices() - 1 ; i++)    {

            Edge edge = graph.getEdgesList().get(i);
            int src = edge.getSrc();
            int dest = edge.getDest();

            int srcParent = find(parent , src);
            int destParent = find( parent , dest);

            if ( srcParent != destParent)   {
                minSpanningTreeEdges.add(edge);
                union( parent , src , dest);
            }
        }

        return  minSpanningTreeEdges;

    }

    private static void union(int[] parent, int src, int dest) {

        int srcParent = find(parent , src);
        int destParent = find(parent , dest);
        parent[srcParent] = destParent;


    }

    private static int find(int[] parent, int vertex) {

        if ( parent[vertex] == -1)
            return vertex;

        return find( parent , parent[vertex]);

    }


}
