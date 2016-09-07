package trees.and.graphs;

import java.util.ArrayList;

public class Graph {
	public int vertices;
	public ArrayList<Integer> adjacencyList[];
	
	Graph(int vertices){
		this.vertices = vertices;
		adjacencyList = new ArrayList[vertices];
		for ( int i = 0 ; i < vertices ; i++)	{
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge( int source , int end)	{
		adjacencyList[source].add(end);
	}
}
