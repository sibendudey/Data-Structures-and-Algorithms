package com.hackerearth.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Graph {	

	int weight[];
	GraphNode [] graphNodes;
	Map<Integer , Integer> weightMapper = null;
	
	public Map<Integer, Integer> getWeightMapper() {
		return weightMapper;
	}

	public Graph( int N)	{
		weight = new int[N];
		graphNodes = new GraphNode[N];
		weightMapper = new HashMap<>();
		initializeGraphNodes();
	}
	
	private void initializeGraphNodes() {
		for ( int i = 0 ; i < graphNodes.length ; i++)
			graphNodes[i] = new GraphNode();
		
	}

	public void sort()	{
		Arrays.sort(weight);
	}
	
		
}
