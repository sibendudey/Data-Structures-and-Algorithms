package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deysi on 3/24/2017.
 */
public class Graph	{
    List<Edge> edgesList;
    int vertices;

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    int edges;

    Graph(int vertices , int edges){
        this.vertices = vertices;
        this.edges = edges;
        edgesList = new ArrayList<Edge>(edges);
    }

    public List<Edge> getEdgesList(){
        return edgesList;
    }

}