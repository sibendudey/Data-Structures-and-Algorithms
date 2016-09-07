package graphs;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;


class Edge	{
	
	int src,edge;
	
	public Edge(int src , int edge){
		this.src = src;
		this.edge = edge;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}
}


class Graph	{
	List<Edge> edgesList;
	int vertices,edges;
	
	Graph(int vertices , int edges){
		this.vertices = vertices;
		this.edges = edges;
		edgesList = new ArrayList<Edge>(edges);
	}
	
	public List<Edge> getEdgesList(){
		return edgesList;
	}
	
}

class Set	{
	int parent;
	int rank;
	
	Set(int parent , int rank)	{
		this.parent = parent;
		this.rank = rank;
	}
}



public class UnionFind {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices = 3 , edges = 3;
		Set [] setList = new Set[vertices];
		for ( int i = 0 ; i < vertices ; i++){
			setList[i] = new Set(i , 0);
		}
	
		Graph graph = new Graph(vertices , edges);
		graph.getEdgesList().add(new Edge(0,1));
		graph.getEdgesList().add(new Edge(1,2));
		graph.getEdgesList().add(new Edge(2,0));
		
		System.out.println(isCyclePresent(graph , setList));
		
}

	private static boolean isCyclePresent(Graph graph, Set[] setList) {
		// TODO Auto-generated method stub
		
		for ( Edge edge : graph.getEdgesList())	{
			int srcValue = edge.getSrc();
			int edgeValue = edge.getEdge();
			
			int srcParent = find(srcValue , setList);
			int edgeParent = find(edgeValue , setList);
			
			if (srcParent == edgeParent){
				return true;
			}
			else	{
				union(srcValue , edgeValue , setList);
			}
		}
		
		return false;
	}

	private static void union(int srcValue, int edgeValue, Set[] setList) {
		// TODO Auto-generated method stub
		
		if ( setList[srcValue].rank >= setList[edgeValue].rank)	{
			setList[edgeValue].parent = setList[srcValue].parent;
		}
		else	{
			setList[srcValue].parent = setList[edgeValue].parent;
		}
		
		if (setList[srcValue].rank == setList[edgeValue].rank)	{
			setList[edgeValue].parent = setList[srcValue].parent;
			setList[srcValue].rank++;
			
		}
		
	}

	private static int find(int value, Set[] setList) {
		// TODO Auto-generated method stub
		if ( setList[value].parent != value)	{
			setList[value].parent = find(setList[value].parent , setList);
		}
		return setList[value].parent;
	}

}
