package graphs;

/**
 * Created by sibendu on 27/3/17.
 */

import java.util.LinkedList;

/**
 * Utility class Graph to store the contents of structure of the Graph
 * Created by deysi on 3/24/2017.
 */
public class GraphAdjacencyList	{
    public int vertices;
    public LinkedList<Integer> adjList[];

    public Graph(int vertices)	{
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for ( int i = 0 ; i < vertices ; i++)	{
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v1 , int v2)	{
        adjList[v1].add(v2);
    }
}