package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class Graph to store the contents of structure of the Graph
 * Created by Sibendu on 3/24/2017.
 */
public class Graph	{
    private List<Edge> edgesList;
    private int vertices , edges;

    private int[] inDegree;

    private LinkedList<Integer> adjList[];

    private LinkedList<Edge> adjListEdge[];

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    public int[] getInDegree() {
        return inDegree;
    }

    public Graph(int vertices , int edges){
        this.vertices = vertices;
        this.edges = edges;
        edgesList = new ArrayList<Edge>(edges);
        inDegree = new int[vertices];
    }

    public List<Edge> getEdgesList(){
        return edgesList;
    }
    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }
    public LinkedList<Edge>[] getAdjListEdge() {
        return adjListEdge;
    }

    public void addEdge( int source , int destination)  {

        if ( adjList == null)
            adjList = new LinkedList[vertices];

        if ( adjList[source] == null)
            adjList[source] = new LinkedList<>();

        adjList[source].add(destination);
    }

    public void addEdgeWithWeight( Edge edge)   {

        if ( adjListEdge == null)
            adjListEdge = new LinkedList[vertices];

        if ( adjListEdge[edge.getSrc()] == null)
            adjListEdge[edge.getSrc()] = new LinkedList<>();

        adjListEdge[edge.getSrc()].add(edge);

    }

    public void addEdgeAndIncrementIndegree( int source , int destination)  {

        if ( adjList == null)
            adjList = new LinkedList[vertices];

        if ( adjList[source] == null)
            adjList[source] = new LinkedList<>();

        adjList[source].add(destination);
        inDegree[destination]++;
    }
}