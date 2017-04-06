package graphs.geeksforgeeks;

import graphs.Edge;
import graphs.Graph;
import graphs.GraphBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by sibendu on 3/4/17.
 *
 * Why -> To check if the graph is bipartite or not. For more explanation ,
 *  refer http://www.geeksforgeeks.org/bipartite-graph/
 *
 *  How -> Graph coloring is performed using any two colors ( say RED and BLUE)
 *          For all the adjacent vertices the colors should be different.
 *          If any adjacent vertex is colored same as the current vertex , return true indicating the vertex
 *          is bipartite , else colour the vertex with opposite color
 *
 *   Time complexity -> O( V + E) is performed using adjacency matrix else O( V * E)
 */
public class CheckBipartite {


    public static void main( String args[]) {

        Graph graph = GraphBuilder.createGraph();

        System.out.println(checkBIPartite( graph));

    }

    private static boolean checkBIPartite(Graph graph) {

        Queue<Integer> queue = new LinkedList<>();

        boolean red[] = new boolean[graph.getVertices()];

        boolean blue[] = new boolean[graph.getVertices()];

        red[0] = true;

        boolean[] visited = new boolean[graph.getVertices()];

        while ( !queue.isEmpty())   {
            int source = queue.element();
            visited[source] = true;

            for ( Edge edge : graph.getEdgesList().stream().filter( edge -> edge.getSrc() == source).collect(Collectors.toList()))   {
                int destination = edge.getDest();
                if ( red[source] == true)    {

                    if ( red[destination] == true)
                        return false;

                    blue[destination] = true;
                    queue.add(destination);
                }
                else if ( blue[source] == true)  {
                    if ( blue[destination] == true)
                        return false;

                    red[destination] = true;
                    queue.add(destination);
                }

            }

        }

        return true;
    }
}
