package trees.and.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalGraph {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode root = createGraph();
		breadthFirstSearch(root);
		
	}

	private static void breadthFirstSearch(GraphNode root) {
		Queue bfs = new LinkedList<GraphNode>();
		bfs.add(root);
		ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
		GraphNode currentNode;
		do	{
			currentNode = (GraphNode)bfs.remove();
			System.out.print(currentNode.getData()+ " ");
			visited.add(currentNode);
			for (int counter = 0; counter < currentNode.getEdges().size(); counter++)	{
				GraphNode tempNode = currentNode.getEdges().get(counter);
				if (!visited.contains(tempNode))	{
					bfs.add(tempNode);
				}
			}
		}while(!bfs.isEmpty());
	}

	private static GraphNode createGraph() {
		// TODO Auto-generated method stub
		GraphNode root = new GraphNode(2);
		root.addEdges(new GraphNode(0));
		root.addEdges(new GraphNode(3));
		GraphNode tempEdge = root.getEdges().get(0);
		tempEdge.addEdges(new GraphNode(1));
		tempEdge = tempEdge.getEdges().get(0);
		tempEdge.addEdges(root);
		tempEdge = root.getEdges().get(1);
		tempEdge.addEdges(tempEdge);
		return root;
	}

}
