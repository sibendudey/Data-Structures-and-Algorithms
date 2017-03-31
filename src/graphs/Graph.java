package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Graph to store the contents of structure of the Graph
 * Created by deysi on 3/24/2017.
 */
public class Graph {
    private List<Edge> edgesList;
    private int vertices, edges;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgesList = new ArrayList<Edge>(edges);
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public List<Edge> getEdgesList() {
        return edgesList;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    public List<Edge> getEdgesListStreamed(int source) {
        return edgesList.stream().filter(Edge -> Edge.getSrc() == source).collect(Collectors.toList());
    }

}