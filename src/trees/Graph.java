package trees;

import java.util.LinkedList;

public class Graph {
	public int vertices;
	public LinkedList<Integer> adjList[];
	
	public Graph(int vertices)	{
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for ( int i = 0 ; i < vertices ; i++)	{
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v1 , int v2)	{
		adjList[v1].add(v2);
	}

}
