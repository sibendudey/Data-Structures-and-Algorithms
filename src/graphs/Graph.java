package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class Graph to store the contents of structure of the Graph
 * Created by deysi on 3/24/2017.
 */
public class Graph	{
    private List<Edge> edgesList;
    private int vertices , edges;

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

    public List<Edge> getEdgesList(){
        return edgesList;
    }

}