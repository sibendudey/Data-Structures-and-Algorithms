package trees.and.graphs;

public class InOrderTraversalMorris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		morrisTraversal(3,root);

	}
	
	
	private static void morrisTraversal(int count,Node root) {
		
		Node current = root;
		int tempCount = 0;
		while(current != null)	{
			
			if (current.getLeftNode() == null)	{
				count++
				System.out.print(current.getData()+" ");
				current = current.getRightNode();
			}
			
			else	{
			  Node pre = current.getLeftNode();
			  while (pre.getRightNode() != null && pre.getRightNode() != current)	{
				  pre = pre.getRightNode();
			  }
			  
			  if (pre.getRightNode() != null)	{
				  pre.setRightNode(current);
				  current = current.getLeftNode();
			  }
			  
			  else	{
				  
			  }
			  
			  
			}
		}
		
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
