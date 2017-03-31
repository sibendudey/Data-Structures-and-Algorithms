package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class Graph to store the contents of structure of the Graph
 * Created by deysi on 3/24/2017.
 */
public class Graph	{
    private List<Edge> edgesList;
    private int vertices , edges;

    private LinkedList<Integer> adjList[];

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    public Graph(int vertices , int edges){
        this.vertices = vertices;
        this.edges = edges;
        edgesList = new ArrayList<Edge>(edges);
    }

    public Graph ( int vertices , int edges , LinkedList<Integer> adjList[] )   {
        this.vertices = vertices;
        this.edges = edges;
        this.adjList = adjList;
    }

    public List<Edge> getEdgesList(){
        return edgesList;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

}