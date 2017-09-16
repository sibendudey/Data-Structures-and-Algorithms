package graphs.geeksforgeeks;

import graphs.Graph;
import graphs.GraphBuilder;

import java.util.Stack;

/**
 * Created by Sibendu Dey on 19/6/17.
 */
public class TopologicalSortAll {
    public static void main(String args[])  {
        Graph graph = GraphBuilder.createGraphWithAdjacencyListAndIndegree();
        boolean visited[] = new boolean[graph.getVertices()];
        Stack<Integer> stack = new Stack<>();
        printAllTopologicalSorts(graph , stack, visited);
    }

    private static void printAllTopologicalSorts(Graph graph, Stack<Integer> stack, boolean[] visited) {


        boolean flag = false;
        for ( int i = 0 ; i < graph.getVertices() ; i++)    {
            if ( graph.getInDegree()[i] == 0 && !visited[i])    {
                if ( graph.getAdjList()[i] != null)
                    for (int j : graph.getAdjList()[i]) {
                        (graph.getInDegree()[j])--;
                    }
                    visited[i] = true;
                    stack.push(i);
                    flag = true;
                    printAllTopologicalSorts(graph, stack, visited);
                    visited[i] = false;
                    stack.pop();

                if ( graph.getAdjList()[i] != null)
                    for (int j : graph.getAdjList()[i]) {
                        (graph.getInDegree()[j])++;
                    }
            }
        }

        if ( !flag) {
            System.out.println(stack.toString());
        }
    }
}
