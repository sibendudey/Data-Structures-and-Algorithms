package graphs;

/**
 * Created by deysi on 3/31/2017.
 */
public class MinHeapNode {

    private int key;
    private int vertex;

    public MinHeapNode(int key, int vertex) {
        this.key = key;
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
