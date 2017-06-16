package trees;

import java.util.ArrayList;

public class NoOfCycles {

	static boolean visited[] = new boolean[5];
	static int noOfCycles = 0;
	static ArrayList<String> visitedEdges = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		findNoOfCycles(graph);
		System.out.println(noOfCycles);
	}

	private static void findNoOfCycles(Graph graph) {
		// TODO Auto-generated method stub
		for ( int i = 1 ; i < graph.vertices ; i++ )	{
			findCycleUtil( -1 , i, graph);
		}
	}

	private static void findCycleUtil(int sourcevertice, int destvertice ,  Graph graph) {
		// TODO Auto-generated method stub
		System.out.println(destvertice);
		if ( visited[destvertice] == true )	{
			System.out.println("In here");
			if ( visitedEdges.contains( sourcevertice + "->" + destvertice))	{
				return;
			}
			else	{
				visitedEdges.add( sourcevertice + "->" + destvertice);
				noOfCycles++;
				return;
			}
		}
		
		else	{
			visited[destvertice] = true;
			for ( int i = 0 ; i < graph.adjacencyList[destvertice].size() ; i++)	{
				findCycleUtil( destvertice , graph.adjacencyList[destvertice].get(i) , graph);
			}
			visited[destvertice] = false;
		}
		
		
	}

}
