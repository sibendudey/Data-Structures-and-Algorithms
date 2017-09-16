package graphs;

//import java.util.HashSet;

class Set	{
	int parent;
	int rank;
	
	Set(int parent , int rank)	{
		this.parent = parent;
		this.rank = rank;
	}
}

/**
 * This program demonstrates the union-find algorithm to detect cycles in a non directed graph
 * @author  Sibendu Dey
 *
 */

public class UnionFindWithRank {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

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

		
		for ( Edge edge : graph.getEdgesList())	{
			int srcValue = edge.getSrc();
			int destValue = edge.getDest();
			
			int srcParent = find(srcValue , setList);
			int edgeParent = find(destValue , setList);
			
			if (srcParent == edgeParent){
				return true;
			}
			else	{
				union(srcValue , destValue , setList);
			}
		}
		
		return false;
	}

	private static void union(int srcValue, int destValue, Set[] setList) {

		
		if ( setList[srcValue].rank >= setList[destValue].rank)	{
			setList[destValue].parent = setList[srcValue].parent;
		}
		else	{
			setList[srcValue].parent = setList[destValue].parent;
		}
		
		if (setList[srcValue].rank == setList[destValue].rank)	{
			setList[destValue].parent = setList[srcValue].parent;
			setList[srcValue].rank++;
			
		}
		
	}

	private static int find(int value, Set[] setList) {
		if ( setList[value].parent != value)	{
			setList[value].parent = find(setList[value].parent , setList);
		}
		return setList[value].parent;
	}

}
