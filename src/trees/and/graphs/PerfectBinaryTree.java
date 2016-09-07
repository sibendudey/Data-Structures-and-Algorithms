package trees.and.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBinaryTree {
	
	static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = Node.createBinaryTree();
		
		printLevelOrder(root,0);
		queue.add(root);
		queue.add(null);
	}

	private static void printLevelOrder(Node root, int level) {
		// TODO Auto-generated method stub
		while (!queue.isEmpty())	{
		
		Node root1 = queue.poll();
		if (root1.leftNode != null)
			queue.add(root1.leftNode);
		
		if (root1.rightNode != null)
			queue.add(root1.rightNode);
		
		}
		
	}

}
