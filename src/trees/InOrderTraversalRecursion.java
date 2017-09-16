package trees;

public class InOrderTraversalRecursion {

	public static void main(String[] args) {
		
		Node root = createTree();
		inOrderTraversal(root);

	}
	
	private static void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		if (root.getLeftNode() != null)	{
			inOrderTraversal(root.getLeftNode());
		}
		
		if (root != null)	{
			System.out.print(root.getData());
		}
		
		if (root.getRightNode() != null)	{
			inOrderTraversal(root.getRightNode());
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
