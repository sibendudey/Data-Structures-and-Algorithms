package trees;

public class InPlaceBSTMinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root =createTree();
		root = convertMinHeap(root);
	}

	private static Node convertMinHeap(Node root) {
		// TODO Auto-generated method stub
		
		if (root == null)
			return null;
		if (root.leftNode == null)	{
			root.rightNode = convertMinHeapUtil(root.rightNode);
			return root;
		}
		else	{
			root.rightNode = convertMinHeapUtil(root.rightNode);
			Node leftSubTreeRoot = convertMinHeapUtil(root.leftNode);
			Node leftSubTreeRightTree = leftSubTreeRoot.rightNode;
			root.leftNode = leftSubTreeRoot.leftNode;
		}
		
		
	}

	private static Node convertMinHeapUtil(Node rightNode) {
		// TODO Auto-generated method stub
		
		
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		 Node root = new Node(8);
		    root.leftNode = new Node(4);
		    root.rightNode = new Node(12);
		    root.rightNode.leftNode = new Node(10);
		    root.rightNode.rightNode = new Node(14);
		    root.leftNode.leftNode = new Node(2);
		    root.leftNode.rightNode = new Node(6);
		    return root;
	}

}
