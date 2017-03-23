package com.hackerearth.graphs;

import java.util.ArrayList;

class GraphNode {
	
	private ArrayList<Integer> adjacencyList = null;
	private int weight;
	
	GraphNode(int weight)	{
		adjacencyList = new ArrayList<>();
		this.weight = weight;
	}
	
	GraphNode()	{
		adjacencyList = new ArrayList<>();
	}
	
	public ArrayList<Integer> getAdjacencyList()	{
		return adjacencyList;
	}
	
	public int getWeight()	{
		return weight;
	}
	
}
