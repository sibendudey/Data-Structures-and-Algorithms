package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

import java.util.Stack;

/**
 * Created by Sibendu on 4/4/17.
 *
 * Why -> To create a topological sort for a DAG graph
 *
 * How -> Modify DFS algorithm by instead of printing the current vertex ,
 *          perform topological sort for adjacent vertices and then push the current vertex
 *          to stack. Print all the elements in the stack.
 *
 * Time Complexity -> O( V + E)
 * Space Complexity -> O( V )
 */
public class TopologicalSort {

    public static void main( String args[]) {

        Graph graph = GraphBuilder.createGraphWithWeightAndAdjacencyList();

        topologicalSort(graph);
    }

    private static void topologicalSort(Graph graph) {

        boolean visited[] = new boolean[graph.getVertices()];
        Stack<Integer> stack = new Stack<>();
        for ( int vertex = 0 ; vertex < graph.getVertices() ; vertex++)    {
            if ( !visited[vertex])   {
                visited[vertex] = true;
                topologicalSortUtil(graph , vertex , stack , visited);
                stack.push(vertex);
            }
        }

        printSolution(stack);

    }

    private static void printSolution(Stack<Integer> stack) {

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

    }

    private static void topologicalSortUtil(Graph graph, int vertex, Stack<Integer> stack, boolean[] visited) {

        if ( graph.getAdjList()[vertex] == null)
            return;

        for ( int adjacentVertex : graph.getAdjList()[vertex])   {
            if ( !visited[adjacentVertex])  {
                visited[adjacentVertex] = true;
                topologicalSortUtil(graph , adjacentVertex , stack , visited);
                stack.push(adjacentVertex);
            }
        }
        }
}
