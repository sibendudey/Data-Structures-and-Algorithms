package graphs;

/**
 * Created by deysi on 3/24/2017.
 */
public class Edge	{

    int src, dest;

    public Edge(int src , int dest){
        this.src = src;
        this.dest = dest;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}
