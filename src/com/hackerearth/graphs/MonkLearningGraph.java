package com.hackerearth.graphs;

import java.util.Scanner;

public class MonkLearningGraph {

	
	public static void main( String args[])	{
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		Graph graph = new Graph(N);
		int M = in.nextInt();
		int k = in.nextInt();
		
		for ( int i = 0 ; i < N ; i++)	{
			graph.weight[i] = in.nextInt();
			graph.getWeightMapper().put(graph.weight[i], i);
		}
		
		for ( int i = 0 ; i < M ; i++)	{
			int X = in.nextInt();
			int Y = in.nextInt();
			
			graph.graphNodes[X-1].getAdjacencyList().add(Y-1);
			graph.graphNodes[Y-1].getAdjacencyList().add(X-1);
		}
		
		graph.sort();
		
		GraphAdapter adapter = new GraphAdapter(graph);
		for ( int i = 0 ; i < N ; i++)	{
			adapter.computeKthNode(i, k);
		}
			
		in.close();
	}
}



class GraphAdapter	{
	
	Graph graph;
	GraphAdapter( Graph graph)	{
		this.graph = graph;
	}
	
	
	public void computeKthNode(int graphNode , int K )	{
		
		int iterator = 0;
		for ( int i = 0 ; i < graph.weight.length ; i++)	{
			
			if ( graphNode == i)
				continue;
			
			int nextNodeWeight = graph.weight[i];
			
			if ( graph.graphNodes[graphNode].getAdjacencyList().contains(graph.weightMapper.get(nextNodeWeight)))
				iterator++;
			
			if ( iterator == K - 1)	{
				System.out.println(graph.getWeightMapper().get(nextNodeWeight) + 1);
				break;
			}
			
		}
		
		
		
	}
}