package trees.and.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		breadthFirstSearch(root);
		
	}

	private static void breadthFirstSearch(Node root) {
		Queue bfs = new LinkedList<Node>();
		bfs.add(root);
		
		Node currentNode;
		do	{
			currentNode = (Node)bfs.remove();
			System.out.print(currentNode.getData());
			if (currentNode.getLeftNode() != null)
				bfs.add(currentNode.getLeftNode());
			if (currentNode.getRightNode() != null)
				bfs.add(currentNode.getRightNode());
		}while(!bfs.isEmpty());
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.setLeftNode(new Node(2));
		root.setRightNode(new Node(3));
		Node leftNode = root.getLeftNode();
		leftNode.setLeftNode(new Node(4));
		leftNode.setRightNode(new Node(5));
		Node rightNode = root.getRightNode();
		rightNode.setLeftNode(new Node(6));
		rightNode.setRightNode(new Node(7));
		return root;
	}

}
