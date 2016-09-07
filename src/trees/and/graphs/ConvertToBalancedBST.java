package trees.and.graphs;

public class ConvertToBalancedBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = Node.createDisBalancedTree();
		Node modifiedTreeRoot = createBalancedTree(root);
	}

	private static Node modifiedTreeRoot createBalancedTree(Node root) {
		// TODO Auto-generated method stub
		if ( root.leftNode.data < root.data)	{
			Node temp = root.leftNode.rightNode;
			root.leftNode.rightNode = root;
		}
		
		
	}

}
