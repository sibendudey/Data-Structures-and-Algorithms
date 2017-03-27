package graphs;

import java.util.Scanner;
/**
 * Created by deysi on 3/24/2017.
 */

public class UnionFindWithoutRank {


    public static void main(String args[])  {

       Graph graph = GraphUtility.createGraph();

        if (findCycle( graph ) == true)
            System.out.println("Cycle");
        else
            System.out.println("Not Cycle");

    }

    private static boolean findCycle(Graph graph) {

        int parent[ ] = new int[graph.getVertices()];

        for ( int i = 0  ; i < parent.length ; i++)
            parent[i] = -1;


        for ( int i = 0 ; i < graph.getEdges() ; i++)    {

            Edge edge = graph.getEdgesList().get(i);

            int src = edge.getSrc();

            int dest = edge.getDest();

            int srcParent = find ( parent , src);

            int destParent = find ( parent , dest);

            if ( srcParent == destParent )
                return true;

            union( parent , src , dest);


        }
    return false;
    }

    private static void union(int[] parent, int src, int dest) {

        int srcParent = find(parent , src);
        int destParent = find(parent , dest);
        parent[srcParent] = destParent;

    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1)
            return vertex;
        return find(parent, parent[vertex]);
    }
}
