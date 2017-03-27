package trees.and.graphs;

import java.util.LinkedList;




public class PrintLeftAndRight {
	
	static Node root;
	static LinkedList<Node> list = new LinkedList<Node>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = Node.createBinaryTree();
		list.add(null);
		list.add(root);
		
		Node current = null;
		while ( !list.isEmpty() && list.size() > 1)	{
			current = list.pop();
			
			if ( current == null)	{
				current = list.pop();
				list.add(null);
				if (current.leftNode != null)
					list.add(current.leftNode);
				
				if (current.rightNode != null)
					list.add(current.rightNode);
				
				System.out.print(current.data + " ");
				
				if (list.peek() == null)	{
					System.out.print(current.data);
					System.out.println();
				}
			}
			else	{
				if (current.leftNode != null)
					list.add(current.leftNode);
				if (current.rightNode != null)
					list.add(current.rightNode);
				
				if (list.peek() == null)	{
					System.out.print(current.data);
					System.out.println();
				}
			}
		}
		
		
		
	}

}
