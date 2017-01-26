package trees.and.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PrintDiagonalTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		printDiagonalTree(root);
	}

	private static void printDiagonalTree(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<Node>();
		//queue.add(root);
		//System.out.print(root.data);
		/*while ( root!= null)	{
			queue.add(root);
			root = root.rightNode;
		}*/
		queue.add(null);
		queue.add(root);
		//queue.add(root);
		while (!queue.isEmpty())	{
			//while (  )
			Node temp = queue.poll();
			if (temp == null && queue.size() >= 1)	{
				System.out.println("");
				temp = queue.poll();
				while ( temp != null)	{
					queue.add(temp);
					temp = temp.rightNode;
					}
				queue.add(null);
				}
			else  if ( temp != null && temp.getleftNode() != null)	{
				queue.add(temp.getleftNode());
				Node leftTemp = temp.getleftNode();
				System.out.print(temp.data + " ");
				System.out.print(temp.getleftNode().data+ " ");
				}
			else if ( temp!= null )	{
				System.out.print(temp.data + " " );
			}
		}
		
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		
		
		Node root = new Node(8);
	    root.leftNode = new Node(3);
	    root.rightNode = new Node(10);
	    root.leftNode.leftNode = new Node(1);
	    root.leftNode.rightNode = new Node(6);
	    root.rightNode.rightNode = new Node(14);
	    root.rightNode.rightNode.leftNode = new Node(13);
	    root.leftNode.rightNode.leftNode = new Node(4);
	    root.leftNode.rightNode.rightNode = new Node(7);
		return root;
	}

}
