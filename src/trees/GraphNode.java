package trees;

import java.util.ArrayList;

public class GraphNode {
	int data;
	ArrayList<GraphNode> edges;
	
	
	public GraphNode(int data)	{
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ArrayList<GraphNode> getEdges() {
		return edges;
	}
	public void addEdges(GraphNode node) {
		if (edges == null)	{
			edges = new ArrayList<GraphNode>();
			edges.add(node);
		}
		else	{
			edges.add(node);
		}
	}

}
